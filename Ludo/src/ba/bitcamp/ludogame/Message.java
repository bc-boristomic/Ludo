package ba.bitcamp.ludogame;

import java.awt.Color;

public class Message {
	
	private int x1;
	private int x2;
	private int x3;
	private int x4;
	private int y1;
	private int y2;
	private int y3;
	private int y4;
	private Color color;
	
	public Message(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4, Color color) {
		super();
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

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getX3() {
		return x3;
	}

	public int getX4() {
		return x4;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public int getY3() {
		return y3;
	}

	public int getY4() {
		return y4;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Message [x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4
				+ ", y1=" + y1 + ", y2=" + y2 + ", y3=" + y3 + ", y4=" + y4
				+ ", color=" + color + "]";
	}
	
	
	

}
