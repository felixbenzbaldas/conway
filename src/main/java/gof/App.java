package gof;

import java.util.HashSet;
import java.util.Set;

public class App {

	private String board;
	
	public Set<Point> calculate(String board) {
		this.board = board;
		Set<Point> newBoard = new HashSet<Point>();
		for (int row = 0; row < 50; row++) {
			for (int column = 0; column < 50; column++) {
				if (willBeAlive(new Point(1,1))) { // XXX
					newBoard.add(new Point(1, 1));
				}
			}
		}
		return newBoard;
	}
	
	private boolean willBeAlive(Point point) {
		if (wasAlive(point)) {
			if (getNumberOfLivingNeighbours() == 2 || getNumberOfLivingNeighbours() == 3) {
				return true;
			}
		} else {
			if (getNumberOfLivingNeighbours() == 3) {
				return true;
			}
		}
		return false;
	}
	
	private boolean wasAlive(Point point) {
		if (point.equals(new Point(1,1))) {
			return board.charAt(4) == 'X'; 
		}
		return false;
	}
	
	private int getNumberOfLivingNeighbours() {
		return getNeighbours().replaceAll("0", "").length();
	}
	
	private String getNeighbours() {
		return board.substring(0, 4) + board.substring(5, 9);
	}
}
