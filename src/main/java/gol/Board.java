package gol;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

	private Set<Point> livingCells;
	
	public Board() {
		livingCells = new HashSet<Point>();
	}
	
	public void setAlive(long x, long y) {
		livingCells.add(new Point(x, y));
	}

	public void stepToNextGeneration() {
		this.livingCells = getPossibleLivingCells_nextGeneration().filter(point -> willBeAlive(point)).collect(Collectors.toSet());
	}
	
	private Stream<Point> getPossibleLivingCells_nextGeneration() {
		return livingCells.stream().map(livingCell -> livingCell.getNeighbours()).flatMap(Function.identity());
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
		return point.getNeighbours().filter( p -> isAlive(p) ).count();
	}
}
