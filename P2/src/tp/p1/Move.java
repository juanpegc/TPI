package tp.p1;

public enum Move {
	LEFT, LEFT2, RIGHT, RIGHT2, DOWN;
	
	public static Move parse(String cadenaEntrada) {
		for (Move move : Move.values())
			if (move.name().equalsIgnoreCase(cadenaEntrada))
				return move;
		return LEFT;
	}
	
}
