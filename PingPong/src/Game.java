import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;//per a millorar els grafics
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;//finestra
import javax.swing.JOptionPane;
import javax.swing.JPanel;//panel

@SuppressWarnings("serial")
public class Game extends JPanel{
	Ball ball = new Ball(this);
	Raqueta raq = new Raqueta(this);
	private void move(){
		raq.move();
		ball.move();		
	}
	public void paint(Graphics g){
		super.paint(g);//borra les anteriors grafics sino es crea una linea creuant tota la pag
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//el render el q fa es suavitzar els grafics del creble de baix 
		ball.paint(g2d);//un cercle que va canviant la seva posicio
		raq.paint(g2d);
	}
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				raq.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				raq.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	public void gameOver(){
		JOptionPane.showMessageDialog(this ,"Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame finestra = new JFrame("PingPong");
		Game joc = new Game();
		finestra.add(joc);
		finestra.setVisible(true);
		finestra.setSize(300, 400);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true){
			joc.move();//criada al metode de menejarte
			joc.repaint();//quan es menja el q fa es tornar a pintar el crecle
			Thread.sleep(10);//el q fa es que puga fer altres coses sino no se pintaria res
			
		}
	}
}