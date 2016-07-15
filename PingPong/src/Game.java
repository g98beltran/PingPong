import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;//per a millorar els grafics
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;//finestra
import javax.swing.JOptionPane;
import javax.swing.JPanel;//panel

@SuppressWarnings("serial")
public class Game extends JPanel{
	Random rand = new Random(System.nanoTime());
	Ball ball = new Ball(this);
	Raqueta raq = new Raqueta(this);
	int speed = 1;
	int score = 0;
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
		//dibuixar la puntuació
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(score), 10, 30);
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
		String[] go = new String[] {"Si","No"};
		int a =JOptionPane.showOptionDialog(null, "El teu score es: "+score+"\nVol seguir juant?",
				"Game Over",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, go,go[0]);
		if(a == 1 || a == -1){
			System.exit(ABORT);
		}else{
			ball.x = rand.nextInt(200);
			ball.ya = 1; 
			ball.xa = 1;
			score = 0;
			speed = 1;
			ball.y = 0;
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame finestra = new JFrame("   PingPong");
		Game joc = new Game();
		finestra.add(joc);
		finestra.setResizable(false);
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