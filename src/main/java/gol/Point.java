package gol;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Point {
	
	public final long x;
	public final long y;
	
	public Point(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Stream<Point> getNeighbours() {
		return LongStream.range(y - 1, y + 2).mapToObj(
			y -> LongStream.range(x - 1, x + 2).mapToObj(x -> new Point(x, y))
			)
			.flatMap(Function.identity())
			.filter(Predicate.isEqual(this).negate());
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
