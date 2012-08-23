package mx.com.sampozaicer.games.framework.sample.keyboardtest;

import java.awt.Frame;

import mx.com.sampozaicer.games.framework.controls.GameKeyboardManager;
import mx.com.sampozaicer.games.framework.core.GameContainer;

public class KeyboardTestFrame extends Frame implements GameContainer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameKeyboardManager keyManager;
	
	public KeyboardTestFrame() {
		super();
		keyManager = new GameKeyboardManager();
		this.addKeyListener(keyManager);
	}
	
	@Override
	public GameKeyboardManager getKeyboardManager() {
		return keyManager;
	}
	
	public static void main(String[] args) {
		KeyboardTestFrame ft = new KeyboardTestFrame();
		ft.setSize(400, 400);
		KeyboardTestGame game = new KeyboardTestGame(ft);
		game.run();
	}
}
