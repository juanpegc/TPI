package tp.p1;

public enum Level {
	EASY(4, 1, 3, 2, 2, 4, 0.1, 3, 0.5),
	HARD(8, 1, 3, 2, 3, 4, 0.3, 2, 0.2),
	INSANE(8, 1, 3, 4, 3, 3, 0.5, 1, 0.1);

	private int regularShipNumber;
	private int regularShipRow;
	private int regularShipCol;
	private int destroyerShipNumber;
	private int destroyerShipRow;
	private int destroyerShipCol;
	private double shootingFrequency;
	private int numCyclesToMoveOneCell;
	private double ovniProbality;

	private Level(int regularShipNumber,
			int regularShipRow,
			int regularShipCol,
			int destroyerShipNumber,
			int destroyerShipRow,
			int destroyerShipCol,
			double shootingFrequency,
			int numCyclesToMoveOneCell,
			double ovniProbality) {
		this.regularShipNumber = regularShipNumber;
		this.regularShipRow = regularShipRow;
		this.regularShipCol = regularShipCol;
		this.destroyerShipNumber = destroyerShipNumber;
		this.destroyerShipRow = destroyerShipRow;
		this.destroyerShipCol = destroyerShipCol;
		this.shootingFrequency = shootingFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniProbality = ovniProbality;
	}

	public int getRegularShipNumber() {
		return regularShipNumber;
	}

	public int getRegularShipRow() {
		return regularShipRow;
	}

	public int getRegularShipCol() {
		return regularShipCol;
	}

	public int getDestroyerShipNumber() {
		return destroyerShipNumber;
	}

	public int getDestroyerShipRow() {
		return destroyerShipRow;
	}

	public int getDestroyerShipCol() {
		return destroyerShipCol;
	}

	public double getShootingFrequency() {
		return shootingFrequency;
	}

	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}

	public double getOVNIProbality() {
		return ovniProbality;
	}

	public static Level parse(String cadenaEntrada) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(cadenaEntrada))
				return level;
		return EASY;
	}

}
