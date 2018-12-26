package gol;

import java.util.HashSet;
import java.util.Set;

public class Board {

	private Set<Point> livingCells;
	private int width = Integer.MAX_VALUE - 1;
	
	public Board(Set<Point> livingCells) {
		this.livingCells = livingCells;
	}

	public Set<Point> calculateLivingCellsOfNextGeneration() {
		Set<Point> livingCells_nextGeneration = new HashSet<Point>();
		for (Point point: getSetOfPossibleLivingCells_nextGeneration()) {
			if (willBeAlive(point)) {
				livingCells_nextGeneration.add(point);
			}
		}
		return livingCells_nextGeneration;
	}
	
	private Set<Point> getSetOfPossibleLivingCells_nextGeneration() {
		Set<Point> set = new HashSet<Point>();
		for (Point point : livingCells) {
			for ( Point neighbourPoint : point.getNeighbours()) {
				if (Math.abs( neighbourPoint.x) < width &&
						Math.abs( neighbourPoint.y) < width ) {
					set.add(neighbourPoint);
				}
			}
		}
		return set;
	}
	
	private boolean willBeAlive(Point point) {
		int numberOfLivingNeighbours = getNumberOfLivingNeighbours(point);
		if (isAlive(point)) {
			if (numberOfLivingNeighbours == 2 || numberOfLivingNeighbours == 3) {
				return true;
			}
		} else {
			if (numberOfLivingNeighbours == 3) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isAlive(Point point) {
		return livingCells.contains(point);
	}
	
	private int getNumberOfLivingNeighbours(Point point) {
		return (int) point.getNeighbours().stream().filter( p -> isAlive(p) ).count();
	}
}
