package gol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import gol.App;
import gol.Point;

public class TestApp {
	private Set<Point> livingCells;
	
	@Test
	public void underpopulation() throws Exception {
		createBoard();
		setAlive(1,1);
		testDead(1,1);
	}
	
	@Test
	public void survive() throws Exception {
		createBoard();
		setAlive(1, 0);
		setAlive(1, 1);
		setAlive(1, 2);
		testAlive(1,1);
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
	
	private void createBoard() {
		livingCells = new HashSet<Point>();
	}
	
	private void setAlive(int x, int y) {
		livingCells.add(new Point(x, y));
	}
	
	private void testDead(int x, int y) {
		assertFalse(new App().calculateLivingCellsOfNextGeneration(livingCells).contains(new Point(x, y)));
	}
	
	private void testAlive(int x, int y) {
		assertTrue(new App().calculateLivingCellsOfNextGeneration(livingCells).contains(new Point(1, 1)));
	}
}