import java.util.HashMap;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {
	
	public static HashMap<String, Sound> soundMap = new HashMap<String, Sound>();
	public static HashMap<String, Music> musicMap = new HashMap<String, Music>();
	
	
	public static void load() {
		
		
		try {
			soundMap.put("sound",new Sound("res/click.wav"));
			soundMap.put("hit",new Sound("res/hit.wav"));
			musicMap.put("music",new Music("res/Gouging-Circle.ogg"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}

}
