package mx.com.sampozaicer.games.framework.sample.keyboardtest;

import java.awt.Frame;

public class KeyboardTestFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public KeyboardTestFrame() {
		super();
	}
	
	public static void main(String[] args) {
		KeyboardTestFrame ft = new KeyboardTestFrame();
		ft.setSize(400, 400);
		KeyboardTestGame game = new KeyboardTestGame(ft);
		game.run();
	}
}
