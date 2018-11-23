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
		assertEquals(new HashSet<Point>(), new App().calculate("0000X0000"));
	}
	
	@Test
	public void survive() throws Exception {
		assertEquals(boardWithLivingCell, new App().calculate("000XXX000"));
	}
	
	@Test
	public void overpopulation() throws Exception {
		assertEquals(new HashSet<Point>(), new App().calculate("0X0XXX0X0"));
	}
	
	
	@Test
	public void birth() throws Exception {
		assertEquals(boardWithLivingCell, new App().calculate("0X0X0X000"));
	}
	
}