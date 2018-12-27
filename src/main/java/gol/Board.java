package gol;

import java.util.HashSet;
import java.util.Set;

public class Board {

	private Set<Point> livingCells;
	
	public Board() {
		livingCells = new HashSet<Point>();
	}
	
	public void setAlive(long x, long y) {
		livingCells.add(new Point(x, y));
	}

	public void stepToNextGeneration() {
		Set<Point> livingCells_nextGeneration = new HashSet<Point>();
		for (Point point: getSetOfPossibleLivingCells_nextGeneration()) {
			if (willBeAlive(point)) {
				livingCells_nextGeneration.add(point);
			}
		}
		this.livingCells = livingCells_nextGeneration;
	}
	
	private Set<Point> getSetOfPossibleLivingCells_nextGeneration() {
		Set<Point> set = new HashSet<Point>();
		for (Point point : livingCells) {
			set.addAll(point.getNeighbours());
		}
		return set;
	}
	
	private boolean willBeAlive(Point point) {
		long livingNeighbours = getNumberOfLivingNeighbours(point);
		if (isAlive(point)) {
			return livingNeighbours == 2 || livingNeighbours == 3;
		} else {
			return livingNeighbours == 3;
		}
	}
	
	public boolean isAlive(long x, long y) {
		return isAlive(new Point(x, y));
	}
	
	private boolean isAlive(Point point) {
		return livingCells.contains(point);
	}
	
	private long getNumberOfLivingNeighbours(Point point) {
		return point.getNeighbours().stream().filter( p -> isAlive(p) ).count();
	}
}
