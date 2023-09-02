import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;




public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		// Play button
		if(game.gameState == Game.STATE.Menu) {
			if(mouseOver(mx,my,210,150,200,64)) {
				game.gameState = Game.STATE.Select;
				//handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				//handler.clearEnemies();
				//handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				AudioPlayer.getSound("sound").play();
				return;
			}
		
			// Help button
			if(mouseOver(mx, my, 210,240,200,64)) {
				game.gameState = Game.STATE.Help;
				AudioPlayer.getSound("sound").play();
	
			}
		}
		
		// back button for help button
		if(game.gameState == Game.STATE.Help) {
			if(mouseOver(mx,my,210,330,200,64)) {
				game.gameState = Game.STATE.Menu;
				AudioPlayer.getSound("sound").play();

				return;
			}
		}
		// try again button
		if(game.gameState == Game.STATE.End) {
			if(mouseOver(mx,my,210,330,200,64)) {
				game.gameState = Game.STATE.Select;
				hud.setLevel(1);
				hud.setScore(0);
				AudioPlayer.getSound("sound").play();
				return;
			}
		}
		
		//quit button
		if(game.gameState == Game.STATE.Menu) {
			if(mouseOver(mx,my,210,330,200,64)) {
			System.exit(1);
			}
		}
		
		////////////////////////////////////////////
		// Normal button
		if(game.gameState == Game.STATE.Select) {
			if(mouseOver(mx,my,210,150,200,64)) {
				game.gameState = Game.STATE.Game;
				game.diff = 0;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				AudioPlayer.getSound("sound").play();
			}
		}
		// Hard button
		if(game.gameState == Game.STATE.Select) {
			if(mouseOver(mx, my, 210,240,200,64)) {
				game.gameState = Game.STATE.Game;
				game.diff = 1;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardEnemy, handler));
				AudioPlayer.getSound("sound").play();
			}
		}
		
		// back button
		if(game.gameState == Game.STATE.Select) {
			if(mouseOver(mx,my,210,330,200,64)) {
				game.gameState = Game.STATE.Menu;
				AudioPlayer.getSound("sound").play();
				return;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
		
	}
	
	public void render(Graphics g) {
		
		if(game.gameState == Game.STATE.Menu) {
			Font fnt = new Font("arial", 1,50);
			Font fnt2 = new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Main Menu",175, 70);
			
			g.setFont(fnt2);
			g.drawString("Play",280, 195);
			g.drawRect(210,150,200,64);
			
			g.setFont(fnt2);
			g.drawString("Help",280, 280);
			g.drawRect(210,240,200,64);
			
			g.setFont(fnt2);
			g.drawString("Quit",280, 375);
			g.drawRect(210,330,200,64);
		}else if(game.gameState == Game.STATE.Help)
		{
			Font fnt = new Font("arial", 1,50);
			Font fnt2 = new Font("arial",1,30);
			Font fnt3 = new Font("arial",1,20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help",250, 70);
			
			g.setFont(fnt3);
			g.drawString("Use W,S,A,D or up,down,left,right arrows to dodge enemies ", 40, 200);
			
			g.setFont(fnt2);
			g.drawString("Back",280, 375);
			g.drawRect(210,330,200,64);
		}else if(game.gameState == Game.STATE.End)
		{
			Font fnt = new Font("arial", 1,50);
			Font fnt2 = new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.red);
			g.drawString("Game Over",180, 70);
			
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawString("You Lost !  Score : " + hud.getScore() , 160, 200);
			
			g.drawRect(210,330,200,64);
			g.setColor(Color.cyan);
			g.setFont(fnt2);
			g.drawString("Try Again",245, 370);
		}else if(game.gameState == Game.STATE.Select) {
			Font fnt = new Font("arial", 1,50);
			Font fnt2 = new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Select Difficulty",140, 70);
			
			g.setFont(fnt2);
			g.drawString("Normal",265, 195);
			g.drawRect(210,150,200,64);
			
			g.setFont(fnt2);
			g.drawString("Hard",280, 280);
			g.drawRect(210,240,200,64);
			
			g.setFont(fnt2);
			g.drawString("Back",280, 375);
			g.drawRect(210,330,200,64);
		}
	}
}
