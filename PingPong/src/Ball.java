import java.awt.Graphics2D;

public class Ball {
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game joc;
	public Ball(Game joc){
		this.joc = joc;
	}
	//metode el q fa es menejar la bola
	void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > joc.getWidth() - 30)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > joc.getHeight() - 30)
			ya = -1;
		
		x = x + xa;
		y = y + ya;
	}
	public void paint(Graphics2D g){
		g.fillOval(x, y, 30, 30);
	}

}
