package gameObjects;

public interface IAttack {

	default boolean performAttack(GameObject other) {
		return false;
	};

	default boolean receiveMissileAttack(int damage) {
		return false;
	};

	default boolean receiveBombAttack(int damage) {
		return false;
	};

	default boolean receiveShockWaveAttack(int damage) {
		return false;
	};
	
	boolean receiveExplosionAttack(int damage);
}
