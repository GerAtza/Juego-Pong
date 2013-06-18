

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.WindowConstants;
import javax.swing.JFrame;

public class PJuego extends javax.swing.JPanel {
	private Bolita bolita;
	private Obstaculo obstaculo1;

	public PJuego(Bolita bolita, Obstaculo obstaculo1){
		this.bolita = bolita;
		this.obstaculo1 = obstaculo1;
		interaccion();
	}
	public PJuego() {
		interaccion();
	}
	private void interaccion() {
		try {
			setPreferredSize(new Dimension(640, 480));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		Color c = new Color(1,1,1);
		g.setColor(c);
		g.fillRect(0, 0, 640, 480);
		c = new Color(255,255,255);
		g.setColor(c);
		g.fillRect(obstaculo1.getX(), obstaculo1.getY(), obstaculo1.getDimx(), obstaculo1.getDimy());
		c = new Color(247,36,94);
		g.setColor(c);
		g.fillOval(bolita.getX(), bolita.getY(), bolita.getDiametro(), bolita.getDiametro());
	}	
	public void actualizar(){
		this.repaint();
	}
}