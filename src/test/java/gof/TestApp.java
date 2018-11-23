package gof;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestApp {
	

	@Test
	public void underpopulation() throws Exception {
		assertEquals("0", calculate("0000X0000"));
	}
	
	@Test
	public void survive() throws Exception {
		assertEquals("X", calculate("000XXX000"));
	}
	
	@Test
	public void overpopulation() throws Exception {
		assertEquals("0", calculate("0X0XXX0X0"));
	}
	
	
	@Test
	public void birth() throws Exception {
		assertEquals("X", calculate("0X0X0X000"));
	}
	
	private String calculate(String board) {
		return willBeAlive(board) ? "X":"0";
	}
	
	private boolean willBeAlive(String board) {
		if (getNumberOfLivingNeighbours(board) > 3) {
			return false;
		}
		if (wasAlive(board)) {
			if (getNumberOfLivingNeighbours(board) > 1) {
				return true;
			}
		} else {
			if (getNumberOfLivingNeighbours(board) == 3) {
				return true;
			}
		}
		return false;
	}
	
	private boolean wasAlive(String board) {
		return board.charAt(4) == 'X'; 
	}
	
	private int getNumberOfLivingNeighbours(String board) {
		return getNeighbours(board).replaceAll("0", "").length();
	}
	
	private String getNeighbours(String board) {
		return board.substring(0, 4) + board.substring(5, 9);
	}
}