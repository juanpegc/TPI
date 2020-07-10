package tp.p1;

import gameObjects.GameObject;
import gameObjects.weapons.Shockwave;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	private int tamMax;

	public GameObjectBoard(int rows, int cols) {
		tamMax = 24; // TODO esto hay que cambiarlo
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
	
/*
	private int getIndex(int row, int col) {
		int i = 0;
		boolean found = false;
		while (i < currentObjects && !found) {
			if (objects[i].getRow() == row && objects[i].getCol() == col)
				return i;
			i++;
		}
		return -1;
	}*//* si vuestra solución requiere que sea public,se puede cambiar */

	private void remove(GameObject object, int index) {
		while (index < currentObjects) {
			objects[index] = objects[index + 1];
			index++;
		}
		objects[index] = null;
		currentObjects--;
	}

	public void update() {
		for (int i = 0; i < currentObjects; i++)
			objects[i].move();
		for (int i = 0; i < currentObjects; i++)
			checkAttacks(objects[i]);
		removeDead();
	}

	private void checkAttacks(GameObject object) {
		for (int i = 0; i < currentObjects; i++) {
			GameObject go = getObjectInPosition(objects[i].getRow(), objects[i].getCol());
			if (!go.equals(object) && go.isAlive() && object.isAlive() && go.isHere(object.getRow(), object.getCol())) {
				object.performAttack(go);
			}
		}
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
}