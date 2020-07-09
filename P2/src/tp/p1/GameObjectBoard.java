package tp.p1;

import gameObjects.GameObject;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	private int tamMax;

	public GameObjectBoard(int rows, int cols) {
		tamMax = rows * cols;
		currentObjects = 0;
		objects = new GameObject[tamMax];
	}
/*
	private int getCurrentObjects() {
		return currentObjects;
	}*/

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
			if(isHere) go = objects[i];
			i++;
		}
		return go;
	}

	private int getIndex(int row, int col) {
		int i = currentObjects - 2;
		boolean found = false;
		while (i >= 0 && !found) {
			if (objects[i].getRow() == row && objects[i].getCol() == col)
				return i;
			i++;
		}
		return -1;
	}/* si vuestra solución requiere que sea public,se puede cambiar */

	public void remove(GameObject object) {
		int i = getIndex(object.getRow(), object.getCol());
		while (i < currentObjects - 1) {
			objects[i] = objects[i + 1];
			i++;
		}
		objects[i] = null;
		currentObjects--;
	}

	public void update() {
		for(int i = 0; i < currentObjects; i++) objects[i].move();
		for(int i = 0; i < currentObjects; i++) checkAttacks(objects[i]);
		removeDead();
	}

	private void checkAttacks(GameObject object) {
		for(int i = 0; i < currentObjects; i++) {
			GameObject go = getObjectInPosition(objects[i].getRow(), objects[i].getCol());
			if(!go.equals(object) && go.isAlive() && object.isAlive() && go.isHere(object.getRow(), object.getCol())) {
				object.performAttack(go);
			}
		}
	}

	public void computerAction() {
		for(int i = 0; i < currentObjects; i++) objects[i].computerAction();
	}

	private void removeDead() {
		for(int i = 0; i < currentObjects; i++) {
			if(!objects[i].isAlive() && !objects[i].isOut()) {
				remove(objects[i]);
			}
		}
	}

	public String toString(int row, int col) {
		GameObject go = getObjectInPosition(row, col);
		if(go == null) return "    ";
		else return go.toString();
	}
}