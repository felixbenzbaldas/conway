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
		
		testDeadInNextGeneration(1,1);
	}
	
	@Test
	public void survive() throws Exception {
		createBoard();
		
						setAlive(1, 0);
						setAlive(1, 1);
						setAlive(1, 2);
		
		testAliveInNextGeneration(1,1);
	}

	@Test
	public void overpopulation() throws Exception {
		createBoard();
		
						setAlive(1, 0);
		setAlive(0, 1); setAlive(1, 1); setAlive(2, 1);
						setAlive(1, 2);

		testDeadInNextGeneration(1,1);
	}
	
	@Test
	public void birth() throws Exception {
		createBoard();
		
						setAlive(1, 0);
		setAlive(0, 1);
						setAlive(1, 2);
		
		testAliveInNextGeneration(1,1);
	}
	
	private void createBoard() {
		livingCells = new HashSet<Point>();
	}
	
	private void setAlive(int x, int y) {
		livingCells.add(new Point(x, y));
	}
	
	private void testDeadInNextGeneration(int x, int y) {
		assertFalse(new App().calculateLivingCellsOfNextGeneration(livingCells).contains(new Point(x, y)));
	}
	
	private void testAliveInNextGeneration(int x, int y) {
		assertTrue(new App().calculateLivingCellsOfNextGeneration(livingCells).contains(new Point(x, y)));
	}
}