package gof;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestApp {

	static Set<Point> boardWithLivingCell = new HashSet<Point>();
	static {
		boardWithLivingCell.add(new Point(1,1));
	}
	
	@Test
	public void underpopulation() throws Exception {

		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(1, 1));
		assertEquals(new HashSet<Point>(), new App().calculate("0000X0000", livingCells));
	}
	
	@Test
	public void survive() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 1));
		livingCells.add(new Point(1, 2));
		
		assertEquals(boardWithLivingCell, new App().calculate("000XXX000", livingCells));
	}
	
	@Test
	public void overpopulation() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(0, 1));
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 1));
		livingCells.add(new Point(1, 2));
		livingCells.add(new Point(2, 1));
		
		assertEquals(new HashSet<Point>(), new App().calculate("0X0XXX0X0", livingCells));
	}
	
	
	@Test
	public void birth() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(0, 1));
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 2));
		
		assertEquals(boardWithLivingCell, new App().calculate("0X0X0X000", livingCells));
	}
	
}