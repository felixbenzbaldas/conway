package gol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import gol.App;
import gol.Point;

public class TestApp {

	@Test
	public void underpopulation() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(1, 1));

		assertFalse(new App().calculateLivingCellsOfNextGeneration(livingCells).contains(new Point(1, 1)));
	}

	@Test
	public void survive() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 1));
		livingCells.add(new Point(1, 2));

		assertTrue(new App().calculateLivingCellsOfNextGeneration(livingCells).contains(new Point(1, 1)));
	}

	@Test
	public void overpopulation() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(0, 1));
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 1));
		livingCells.add(new Point(1, 2));
		livingCells.add(new Point(2, 1));

		assertFalse(new App().calculateLivingCellsOfNextGeneration(livingCells).contains(new Point(1, 1)));
	}
	
	@Test
	public void birth() throws Exception {
		Set<Point> livingCells = new HashSet<Point>();
		livingCells.add(new Point(0, 1));
		livingCells.add(new Point(1, 0));
		livingCells.add(new Point(1, 2));
		
		assertTrue(new App().calculateLivingCellsOfNextGeneration(livingCells).contains(new Point(1, 1)));
	}
}