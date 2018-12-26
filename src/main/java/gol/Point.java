package gol;

import java.util.HashSet;
import java.util.Set;

public class Point {
	
	public final int x;
	public final int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Set<Point> getNeighbours() {
		Set<Point> neighbours = new HashSet<Point>();
		neighbours.add(new Point(x - 1, y - 1));
		neighbours.add(new Point(x - 1, y    ));
		neighbours.add(new Point(x - 1, y + 1));
		neighbours.add(new Point(x, y - 1));
		neighbours.add(new Point(x, y + 1));
		neighbours.add(new Point(x + 1, y - 1));
		neighbours.add(new Point(x + 1, y    ));
		neighbours.add(new Point(x + 1, y + 1));
		return neighbours;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
