import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float alpha = 1;
	private Handler handler;
	private Color color;
	private float life;
	
	private int width, height;
	
	public Trail(float x, float y, ID id, Color color, int width, int height, float life,Handler handler) {
		super(x, y, id);
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
		this.handler = handler;
	}

	public void tick() {
		// TODO Auto-generated method stub
		if(alpha > life) {
			alpha -= (life - 0.001f);
		}else handler.removeObject(this);
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect((int)x,(int) y, width, height);
		
		g2d.setComposite(makeTransparent(1));
	}

	
	private AlphaComposite makeTransparent(float alpha) {
		
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type,alpha));
	}
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
