package ba.bitcamp.ludogame;

/**
 * 
 * @author Becir Omerbasic
 * @author Edin Pilavdzic
 * @author Nidal Salkic
 * @author Boris Tomic
 *
 */
public class Message {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int x4;
	private int y4;
	private String color;

	/**
	 * Default empty constructor that calls super constructor.
	 */
	public Message() {
		super();
	}

	/**
	 * Another constructor of Message class used to set X and Y values of all
	 * pawns from one player.
	 * 
	 * @param x1
	 *            <code>int</code> type value of X coordinates for pawn 1
	 * @param y1
	 *            <code>int</code> type value of Y coordinates for pawn 1
	 * @param x2
	 *            <code>int</code> type value of X coordinates for pawn 2
	 * @param y2
	 *            <code>int</code> type value of X coordinates for pawn 2
	 * @param x3
	 *            <code>int</code> type value of X coordinates for pawn 3
	 * @param y3
	 *            <code>int</code> type value of X coordinates for pawn 3
	 * @param x4
	 *            <code>int</code> type value of X coordinates for pawn 4
	 * @param y4
	 *            <code>int</code> type value of X coordinates for pawn 4
	 * @param color
	 *            <code>String</code> type value of color used by player
	 */
	public Message(int x1, int y1, int x2, int y2, int x3, int y3, int x4,
			int y4, String color) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
		this.color = color;
	}

	/**
	 * Returns coordinates from X axis of pawn 1
	 * 
	 * @return <code>int</code> type value of X coordinates for pawn 1
	 */
	public int getX1() {
		return x1;
	}

	/**
	 * Returns coordinates from Y axis of pawn 1
	 * 
	 * @return <code>int</code> type value of Y coordinates for pawn 1
	 */
	public int getY1() {
		return y1;
	}

	/**
	 * Returns coordinates from X axis of pawn 2
	 * 
	 * @return <code>int</code> type value of X coordinates for pawn 2
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * Returns coordinates from Y axis of pawn 2
	 * 
	 * @return <code>int</code> type value of Y coordinates for pawn 2
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * Returns coordinates from X axis of pawn 3
	 * 
	 * @return <code>int</code> type value of X coordinates for pawn 3
	 */
	public int getX3() {
		return x3;
	}

	/**
	 * Returns coordinates from Y axis of pawn 3
	 * 
	 * @return <code>int</code> type value of Y coordinates for pawn 3
	 */
	public int getY3() {
		return y3;
	}

	/**
	 * Returns coordinates from X axis of pawn 4
	 * 
	 * @return <code>int</code> type value of X coordinates for pawn 4
	 */
	public int getX4() {
		return x4;
	}

	/**
	 * Returns coordinates from Y axis of pawn 4
	 * 
	 * @return <code>int</code> type value of Y coordinates for pawn 4
	 */
	public int getY4() {
		return y4;
	}

	/**
	 * Returns <code>String</code> type value of color used by player
	 * 
	 * @return <code>String</code> type value of color
	 */
	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Message [x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4
				+ ", y1=" + y1 + ", y2=" + y2 + ", y3=" + y3 + ", y4=" + y4
				+ ", color=" + color + "]";
	}

}
