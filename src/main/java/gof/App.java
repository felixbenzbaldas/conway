package gof;

public class App {

	private String board;
	
	public String calculate(String board) {
		this.board = board;
		return willBeAlive(new Point(1,1)) ? "X":"0";
	}
	
	private boolean willBeAlive(Point point) {
		if (wasAlive(point)) {
			if (getNumberOfLivingNeighbours() == 2 || getNumberOfLivingNeighbours() == 3) {
				return true;
			}
		} else {
			if (getNumberOfLivingNeighbours() == 3) {
				return true;
			}
		}
		return false;
	}
	
	private boolean wasAlive(Point point) {
		if (point.equals(new Point(1,1))) {
			return board.charAt(4) == 'X'; 
		}
		return false;
	}
	
	private int getNumberOfLivingNeighbours() {
		return getNeighbours().replaceAll("0", "").length();
	}
	
	private String getNeighbours() {
		return board.substring(0, 4) + board.substring(5, 9);
	}
}
