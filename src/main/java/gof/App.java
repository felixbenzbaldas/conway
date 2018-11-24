package gof;

import java.util.HashSet;
import java.util.Set;

public class App {

	private Set<Point> livingCells;
	
	public Set<Point> calculateLivingCellsOfNextGeneration(Set<Point> livingCells) {
		this.livingCells = livingCells;
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
			set.addAll(point.getNeighbours());
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
	
	private boolean isAlive(Point point) {
		return livingCells.contains(point);
	}
	
	private int getNumberOfLivingNeighbours(Point point) {
		int sum = 0;
		for (Point currentNeighbour: point.getNeighbours()) {
			if (isAlive(currentNeighbour)) {
				sum++;
			}
		}
		return sum;
	}
}
