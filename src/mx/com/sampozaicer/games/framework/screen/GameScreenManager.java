package mx.com.sampozaicer.games.framework.screen;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class GameScreenManager {
	
	private GameCanvas canvas;
	private final int BUFFER_STRATEGY_NUM = 2;
	
	/*
	 * Initializes a new game canvas, and adds it to the specified container
	 */
	public void addNewGameCanvas(Container c) {
		canvas = new GameCanvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(c.getSize());
		canvas.setBackground(Color.WHITE);
		canvas.setForeground(Color.GREEN);
		
		c.add(canvas);
		c.setVisible(true);
		
		canvas.createBufferStrategy(BUFFER_STRATEGY_NUM);
	}
	
	/*
	 * Return the GameCanvas Graphics object
	 */
	public Graphics getGraphics() {
		if(canvas != null) {
			return canvas.getBufferStrategy().getDrawGraphics();
		} else {
			return null;
		}
	}
	
	/*
	 * Displays the next buffer in the canvas
	 */
	public void updateGameCanvas() {
		if(canvas != null) {
			BufferStrategy bs = canvas.getBufferStrategy();
			if(!bs.contentsLost()) {
				bs.show();
				Toolkit.getDefaultToolkit().sync();
			}
		}
	}

}
