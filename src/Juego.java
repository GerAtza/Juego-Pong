

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Juego extends JFrame {
	private JMenuBar MBMunu;
	private JPanel PGrafica;
	private JMenuItem MISalir;
	private JMenuItem MINuevo;
	private JMenu MArchivo;
	private PJuego pjuego;
	private Bolita bolita;
	private Timer tiempo;
	private Obstaculo obstaculo1;
	private int mas=5,menos=-5;
	
	public Juego() {
		interaccion();
	}
	
	private void interaccion() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(null);
			PGrafica = new JPanel();
			getContentPane().add(PGrafica);
			PGrafica.setBounds(30, 30, 640, 480);
			PGrafica.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					Movimientos(evt);
				}
			});
						
			MBMunu = new JMenuBar();
			setJMenuBar(MBMunu);
				
			MArchivo = new JMenu();
			MBMunu.add(MArchivo);
			MArchivo.setText("Archivo");
				
			MINuevo = new JMenuItem();
			MArchivo.add(MINuevo);
			MINuevo.setText("Nuevo");
			MINuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Accion();
				}
			});
						
			MISalir = new JMenuItem();
			MArchivo.add(MISalir);
			MISalir.setText("Salir");
			MISalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			});
			pack();
			this.setSize(700, 580);
			Accion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void Accion() {
		bolita = new Bolita();
		obstaculo1 = new Obstaculo();
		pjuego = new PJuego(bolita,obstaculo1);
		this.pjuego.setBounds(0,0,640,480);
		this.PGrafica.add(pjuego);
		this.PGrafica.requestFocus();
		this.tiempo = new Timer();
	    TimerTask t = new TimerTask(){
	    	public void run(){
	    		tiempo();
	    	}
	    };
	    this.tiempo.scheduleAtFixedRate(t, 0, 70);
	}
	
	public void tiempo(){
		//LadoBarra Superior
		if((this.bolita.getY())<=0){
			this.bolita.setDesy(mas);
		}
		//Lado Barra Inferior.
		if((this.bolita.getY()+50)>=480){
			this.bolita.setDesy(menos);
		}
		
		//Regresa pelota al  pasar Barra
		if((this.bolita.getX())<=0){
			this.bolita.setX(295);
			this.bolita.setY(215);
		}
		//
		if((this.bolita.getX()+50)>=640){
			this.bolita.setDesy(mas);
			this.bolita.setDesx(menos);
			this.bolita.setDesy(menos);
		}
		
		for(int i=0;i<100;i++){
			if((this.bolita.getY()+25)==(this.obstaculo1.getY()+i)&&(this.bolita.getX())<=(this.obstaculo1.getX()+25)){
				this.bolita.setDesx(mas);
			}
		}
		
		this.bolita.setY(this.bolita.getY()+this.bolita.getDesy());
		this.bolita.setX(this.bolita.getX()+this.bolita.getDesx());
	    this.pjuego.actualizar();
	}
	
	public void Movimientos(KeyEvent evt) {
		switch(evt.getKeyCode()){
			case 38:
				if(obstaculo1.getY()>0){
					obstaculo1.setY(obstaculo1.getY()-15);
				}
				break;
			case 40:
				if(obstaculo1.getY()+100<480){
					obstaculo1.setY(obstaculo1.getY()+15);	
				}
				break;
		}
	}
}
