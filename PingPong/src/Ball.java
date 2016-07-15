import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
//clase ball que es el sprite de la pilota
public class Ball {
	Random rand = new Random(System.nanoTime());
	private static final int DIAMETER = 30;
	int x = rand.nextInt(200);//pos inicial
	int y = 0;//pos inicial
	int xa = 1;//variable per canviar de direcció
	int ya = 1;//variable per canviar de direcció
	private Game joc;//variable de tipus joc(clase principal) "Game"
	//constructor en el q aguarda la variable joc
	public Ball(Game joc){
		this.joc = joc;
	}
	//metode el q fa es menejar la bola
	public void move() {
		//cada if provoca una restricció per a canviar de direcció
		if (x + xa < 0){
			xa = joc.speed;
		}
		else if (x + xa > joc.getWidth() - DIAMETER){
			xa = -joc.speed;
		}
		else if (y + ya < 0){
			ya = joc.speed;
		}
		else if (y + ya > 331){
			joc.gameOver();
			//ya = -1;			
		}	
		else if (collision()){
			ya = -joc.speed;
			y = joc.raq.getTopY() - DIAMETER;
			if(joc.score == 2 || joc.score == 6 || joc.score == 14 || joc.score == 20){
				joc.speed++;
			}
			joc.score++;
		}
		x = x + xa;//aumenta 1 o -1 segons la direcció
		y = y + ya;//aumenta 1 o -1 segons la direcció
	}
	public void paint(Graphics2D g){
		g.setColor(Color.RED);
		g.fillOval(x, y, DIAMETER, DIAMETER);//bola
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,DIAMETER,DIAMETER);
	}
	private boolean collision(){
		return joc.raq.getBounds().intersects(getBounds());
	}	

}
