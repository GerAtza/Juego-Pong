

public class Obstaculo {
	private int x=25;
	private int y=215;
	private int dimx=25;
	private int dimy=100;
	
	public Obstaculo() {
	}
	public Obstaculo(int x, int y, int dimx, int dimy) {
		super();
		this.x = x;
		this.y = y;
		this.dimx = dimx;
		this.dimy = dimy;
	}
	public int getDimx() {
		return dimx;
	}
	public void setDimx(int dimx) {
		this.dimx = dimx;
	}
	public int getDimy() {
		return dimy;
	}
	public void setDimy(int dimy) {
		this.dimy = dimy;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}