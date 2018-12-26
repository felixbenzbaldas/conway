package gol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestApp {
	private Board board;
	
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
		board = new Board();
	}
	
	private void setAlive(int x, int y) {
		board.setAlive(x, y);
	}
	
	private void testDeadInNextGeneration(int x, int y) {
		board.stepToNextGeneration();
		assertFalse(board.isAlive(x, y));
	}
	
	private void testAliveInNextGeneration(int x, int y) {
		board.stepToNextGeneration();
		assertTrue(board.isAlive(x, y));
	}
}