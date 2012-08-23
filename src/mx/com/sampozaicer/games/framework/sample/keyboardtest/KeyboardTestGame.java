package mx.com.sampozaicer.games.framework.sample.keyboardtest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import mx.com.sampozaicer.games.framework.core.GameCore;

public class KeyboardTestGame extends GameCore {

	private String msg;
	private String msg2;
	private String msg3;
	private double elapsedTime;
	private int frames;
	private int msgId = 0; 
	
	public KeyboardTestGame(Container c) {
		super(c);
		msg = "";
		msg2 = "";
		msg3 = "";
	}

	@Override
	protected void update(long timePassed) {
		
		elapsedTime = totalTime/1000.0;
		msg3 = "FPS: " + frames/elapsedTime;
		
		if(gkm != null) {
			if(gkm.isKeyPressed(KeyEvent.VK_W)) {
				msg = msgId+ "-Pressing key: W";
				msgId++;
			}
			if(gkm.isKeyReleased(KeyEvent.VK_W)) {
				msg = msgId + "-Released key: W";
				msgId++;
			}
			if(gkm.isKeyPressed(KeyEvent.VK_A)) {
				msg = msgId+ "-Pressing key: A";
				msgId++;
			}
			if(gkm.isKeyReleased(KeyEvent.VK_A)) {
				msg = msgId + "-Released key: A";
				msgId++;
			}
			
			msg2 = "";
			for(int k : gkm.getCurrentPressedKeys()) {
				msg2+= KeyEvent.getKeyText(k) + "-";
			}

			gkm.update();
		}
		frames++;
	}

	@Override
	protected void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, gsm.getWidth(), gsm.getHeight());
		g.setColor(Color.GREEN);
		g.drawString("Seconds since started: " + elapsedTime, 30, 30);
		g.drawString(msg, 30, 70);
		g.drawString(msg2, 30, 110);
		g.drawString(msg3, 30, 150);
	}

}
