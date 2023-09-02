import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1Bullet extends GameObject{
	
	private Handler handler;
	Random r = new Random();

	public Boss1Bullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}

	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		//if(y <= 0 || y >= Game.HEIGHT-55) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH-27) velX *= -1;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail( x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));

	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
	}
	
	
	

}
