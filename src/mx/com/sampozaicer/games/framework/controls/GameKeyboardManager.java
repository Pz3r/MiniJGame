package mx.com.sampozaicer.games.framework.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameKeyboardManager implements KeyListener {

	public static final int NUMBER_OF_KEYS = 256;
	
	private boolean[] pressedKeys = new boolean[NUMBER_OF_KEYS];
	private boolean[] releasedKeys = new boolean[NUMBER_OF_KEYS];
	
	private boolean keyPressed = false;
	private boolean keyReleased = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode > 0 && keyCode < NUMBER_OF_KEYS) {
			pressedKeys[keyCode] = true;
			releasedKeys[keyCode] = false;
			keyPressed = true;
			keyReleased = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode > 0 && keyCode < NUMBER_OF_KEYS) {
			pressedKeys[keyCode] = false;
			releasedKeys[keyCode] = true;
			keyPressed = false;
			keyReleased = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	public boolean isKeyPressed(int key) {
		return pressedKeys[key];
	}
	
	public boolean isKeyReleased(int key) {
		return releasedKeys[key];
	}
	
	public void update() {
		releasedKeys = new boolean[256];
		keyReleased = false;
	}

	public boolean isKeyPressed() {
		return keyPressed;
	}

	public boolean isKeyReleased() {
		return keyReleased;
	}
	
	public ArrayList<Integer> getCurrentPressedKeys() {
		ArrayList<Integer> keys = new ArrayList<Integer>();
		for(int i = 0; i < NUMBER_OF_KEYS; i++) {
			if(isKeyPressed(i)) 
				keys.add(i);
		}
		return keys;
	}
}
