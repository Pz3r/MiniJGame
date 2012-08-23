package mx.com.sampozaicer.games.framework.core;

import java.awt.Container;
import java.awt.Graphics;

import mx.com.sampozaicer.games.framework.controls.GameKeyboardManager;
import mx.com.sampozaicer.games.framework.screen.GameScreenManager;

public abstract class GameCore {

	protected boolean running;
	protected Container gameContainer;
	protected GameScreenManager gsm;
	protected GameKeyboardManager gkm;
	protected long totalTime;
	private long timePassed;
	private long accumTime;
	
	public GameCore(Container c) {
		this.gameContainer = c;
		gkm = new GameKeyboardManager();
		c.addKeyListener(gkm);
	}
	
	/*
	 * Start the game
	 */
	public void run() {
		try {
			init();
			gameLoop();
		} finally {
			 //Return to non fullscreen mode 
		}
	}
	
	public void stop() {
		running = false;
	}
	
	/*
	 * Initialized the game. Place to load images and assets.
	 */
	protected void init() {
		gsm = new GameScreenManager();
		gsm.addNewGameCanvas(gameContainer);
		running = true;
	}
	
	/*
	 * Contain the game's main loop
	 */
	protected void gameLoop() {
		totalTime = 0;
		accumTime = System.currentTimeMillis();
		
		while(running) {
			timePassed = System.currentTimeMillis() - accumTime;
			totalTime += timePassed;
			accumTime += timePassed;
			
			update(timePassed); //Update Game's state
			
			Graphics g = gsm.getGraphics();
			render(g); //Render game's objects
			g.dispose();
			
			gsm.updateGameCanvas(); //Show rendered objects
			
			try {
				Thread.sleep(15);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected abstract void update(long timePassed);
	protected abstract void render(Graphics g);

	
}
