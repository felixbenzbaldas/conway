package gol;

import java.util.HashSet;
import java.util.Set;

public class Point {
	
	public final long x;
	public final long y;
	
	public Point(long x, long y) {
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
		result = prime * result + (int) (x ^ (x >>> 32));
		result = prime * result + (int) (y ^ (y >>> 32));
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
