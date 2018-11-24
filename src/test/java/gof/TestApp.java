package gof;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		
		Set<Point> livingCells_nextGeneration = new HashSet<Point>();
		
		assertEquals(livingCells_nextGeneration, new App().calculate(livingCells));
	}
	
	@Test
	public void survive() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 1));
		livingCells.add(new Point(1, 2));

		Set<Point> livingCells_nextGeneration = new HashSet<Point>();
//		livingCells_nextGeneration.add(new Point(0, 1));
		livingCells_nextGeneration.add(new Point(1, 1));
//		livingCells_nextGeneration.add(new Point(2, 1));
		
		assertEquals(livingCells_nextGeneration, new App().calculate(livingCells));
	}
	
	@Test
	public void overpopulation() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(0, 1));
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 1));
		livingCells.add(new Point(1, 2));
		livingCells.add(new Point(2, 1));
		
		assertTrue(!new App().calculate(livingCells).contains(new Point(1,1)));
	}
	
	
	@Test
	public void birth() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(0, 1));
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 2));
		
		assertTrue(new App().calculate(livingCells).contains(new Point(1,1)));
	}
}