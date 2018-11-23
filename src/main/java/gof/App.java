package gof;

import java.util.HashSet;
import java.util.Set;

public class App {

	private String board;
	private Set<Point> asList;
	
	public Set<Point> calculate(String board, Set<Point> asList) {
		this.board = board;
		this.asList = asList;
		Set<Point> newBoard = new HashSet<Point>();
		for (Point point: getSetOfPossibleLivingCells()) {
			if (willBeAlive(new Point(1,1))) { // XXX
				newBoard.add(new Point(1, 1));
			}
		}
		return newBoard;
	}
	
	public Set<Point> calculate(String board) {
		this.board = board;
		Set<Point> newBoard = new HashSet<Point>();
		for (Point point: getSetOfPossibleLivingCells()) {
			if (willBeAlive(new Point(1,1))) { // XXX
				newBoard.add(new Point(1, 1));
			}
		}
		return newBoard;
	}
	
	private Set<Point> getSetOfPossibleLivingCells() {
		Set<Point> set = new HashSet<Point>();
		for (int row = 0; row < 50; row++) {
			for (int column = 0; column < 50; column++) {
				set.add(new Point(row, column));
			}
		}
		return set;
	}
	
	private boolean willBeAlive(Point point) {
		if (wasAlive(point)) {
			if (getNumberOfLivingNeighbours(point) == 2 || getNumberOfLivingNeighbours(point) == 3) {
				return true;
			}
		} else {
			if (getNumberOfLivingNeighbours(point) == 3) {
				return true;
			}
		}
		return false;
	}
	
	private boolean wasAlive(Point point) {
		return asList.contains(point);
	}
	
	private int getNumberOfLivingNeighbours(Point point) {
		return getNeighbours(point).replaceAll("0", "").length();
	}
	
	private String getNeighbours(Point point) {
		Set<Point> neighbours = new HashSet<Point>();
		neighbours.add(new Point(point.x - 1, point.y - 1));
		neighbours.add(new Point(point.x - 1, point.y    ));
		neighbours.add(new Point(point.x - 1, point.y + 1));
		neighbours.add(new Point(point.x, point.y - 1));
		neighbours.add(new Point(point.x, point.y + 1));
		neighbours.add(new Point(point.x + 1, point.y - 1));
		neighbours.add(new Point(point.x + 1, point.y    ));
		neighbours.add(new Point(point.x + 1, point.y + 1));
		
		return board.substring(0, 4) + board.substring(5, 9);
	}
}
