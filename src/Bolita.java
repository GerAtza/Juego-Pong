

public class Bolita {
	private int x=295;
	private int y=215;
	private int diametro=50;
	private int desx=-5;
	private int desy=-5;
	
	public Bolita(){
	}
	public Bolita(int x, int y, int diametro) {
		super();
		this.x = x;
		this.y = y;
		this.diametro = diametro;
	}
	public int getDesx() {
		return desx;
	}
	public void setDesx(int desx) {
		this.desx = desx;
	}
	public int getDesy() {
		return desy;
	}
	public void setDesy(int desy) {
		this.desy = desy;
	}
	public int getDiametro() {
		return diametro;
	}
	public void setDiametro(int diametro) {
		this.diametro = diametro;
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