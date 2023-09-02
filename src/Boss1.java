import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1 extends GameObject{
	
	private Handler handler;
	Random r = new Random();

	private int timer = 100;
	private int timer2 = 50;
	
	
	public Boss1(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 96, 96);
	}

	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(timer <= 0) velY = 0;
		else timer --;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0 )
		{
			if(velX == 0) velX = 2;
			
			// speed up the boss
			if(velX > 0)
				velX += 0.005f;
			if(velX < 0)
				velX -= 0.005f;
			
			velX = Game.clamp(velX,  -10,  10);
			
			
			int spawn = r.nextInt(10);
			if(spawn ==0) handler.addObject(new Boss1Bullet((int) x + 48,(int) y, ID.BasicEnemy, handler));
			
		}
		
	//	if(y <= 0 || y>= Game.HEIGHT-55) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-94) velX *= -1;
		
	//	handler.addObject(new Trail( x, y, ID.Trail, Color.red, 96, 96, 0.001f, handler));

	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 96, 96);
	}
	
	
	

}
