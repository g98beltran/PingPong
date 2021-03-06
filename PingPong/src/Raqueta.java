import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raqueta {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Game joc;
	public Raqueta(Game joc){
		this.joc = joc;
	}
	public void move(){
		if (x + xa > 0 && x + xa < joc.getWidth()- WIDTH)
			x = x + xa;
	}
	public void paint(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -joc.speed;//Aquest joc.speed deuria de ser joc.getspeed() pero en els jocs es fa aixina
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = joc.speed;
	}
	public Rectangle getBounds(){
		return new Rectangle(x, Y, WIDTH, HEIGHT);		
	}
	public int getTopY() {
		return Y;
	}
}
