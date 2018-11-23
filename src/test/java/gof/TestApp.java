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
	
	private String board;
	
	private String calculate(String board) {
		this.board = board;
		return willBeAlive() ? "X":"0";
	}
	
	private boolean willBeAlive() {
		if (getNumberOfLivingNeighbours() > 3) {
			return false;
		}
		if (wasAlive()) {
			if (getNumberOfLivingNeighbours() > 1) {
				return true;
			}
		} else {
			if (getNumberOfLivingNeighbours() == 3) {
				return true;
			}
		}
		return false;
	}
	
	private boolean wasAlive() {
		return board.charAt(4) == 'X'; 
	}
	
	private int getNumberOfLivingNeighbours() {
		return getNeighbours().replaceAll("0", "").length();
	}
	
	private String getNeighbours() {
		return board.substring(0, 4) + board.substring(5, 9);
	}
}