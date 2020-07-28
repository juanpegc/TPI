package tp.p1;

import gameObjects.GameObject;
import gameObjects.weapons.Shockwave;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	private int tamMax;

	public GameObjectBoard(int rows, int cols) {
		tamMax = 24;
		currentObjects = 0;
		objects = new GameObject[tamMax];
	}

	public void add(GameObject object) {
		if (currentObjects < tamMax) {
			objects[currentObjects] = object;
			currentObjects++;
		}
	}

	public GameObject getObjectInPosition(int row, int col) {
		GameObject go = null;
		boolean isHere = false;
		int i = 0;
		while (i < currentObjects && !isHere) {
			isHere = objects[i].isHere(row, col);
			if (isHere)
				go = objects[i];
			i++;
		}
		return go;
	}

	public int getIndex(int row, int col) {
		int i = 0;
		boolean found = false;
		while (i < currentObjects && !found) {
			if (objects[i].getRow() == row && objects[i].getCol() == col)
				return i;
			i++;
		}
		return -1;
	}

	public void remove(GameObject object, int index) {
		while (index < currentObjects) {
			objects[index] = objects[index + 1];
			index++;
		}
		objects[index] = null;
		currentObjects--;
	}

	public void update() {
		for (int i = 0; i < currentObjects; i++) {
			objects[i].move();
		}
		removeDead();
	}
	
	public boolean replaceObject(GameObject oldGO, GameObject newGO) {
		boolean found = false;
		int i = 0;
		while (i < currentObjects && !found) {
			found = objects[i].equals(oldGO);
			if (found) objects[i] = newGO;
			i++;
		}
		
		return found;
	}

	public void computerAction() {
		for (int i = 0; i < currentObjects; i++)
			objects[i].computerAction();
	}

	private void removeDead() {
		int max = currentObjects;
		for (int i = 0; i < max; i++) {
			if (objects[i] != null && !objects[i].isAlive() && !objects[i].isOut()) {
				remove(objects[i], i);
				i--;
			}
		}
	}

	public void laseToAll() {
		for (int i = 0; i < currentObjects; i++) {
			objects[i].receiveShockWaveAttack(Shockwave.DAMAGE);
		}
	}

	public String toString(int row, int col) {
		GameObject go = getObjectInPosition(row, col);
		if (go == null)
			return "    ";
		else
			return go.toString();
	}

	public String toPlainText() {
		String value = "";

		for (int i = 0; i < currentObjects; i++) {
			value += objects[i].toPlainText();
		}

		return value;
	}

	public boolean hasBomb(int number) {
		int i = 0;
		boolean found = false;
		while (i < currentObjects && !found) {
			if (objects[i].getNumber() == number)
				found = true;
			i++;
		}
		return found;
	}

}