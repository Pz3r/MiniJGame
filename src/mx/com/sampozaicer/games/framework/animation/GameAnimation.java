package mx.com.sampozaicer.games.framework.animation;

import java.awt.Image;
import java.util.ArrayList;

public class GameAnimation {
	
	protected ArrayList<GameAnimationFrame> sequence;
	private long totalTime;
	private long movieTime;
	private int index;
	
	public GameAnimation() {
		sequence = new ArrayList<GameAnimationFrame>();
	}
	
	public synchronized void update(long timePassed) {
		if(sequence.size() > 0) {
			movieTime += timePassed;
			if(movieTime >= totalTime) {
				restartAnimation();
			}
			
			GameAnimationFrame current = sequence.get(index);
			while(current.getEndTime() < movieTime) {
				index++;
			}
		}
	}
	
	private void restartAnimation() {
		movieTime = 0;
		index = 0;
	}
	
	public void addFrame(Image img, long duration) {
		totalTime += duration;
		GameAnimationFrame temp = new GameAnimationFrame(img, duration, totalTime);
		sequence.add(temp);
	}
	
	public Image getCurrentImage() {
		if(sequence.size() > 0) {
			return sequence.get(index).getImg();	
		} else {
			return null;
		}
	}

	class GameAnimationFrame {
		private Image img;
		private long duration;
		private long endTime;
		
		public GameAnimationFrame(Image img, long duration, long endTime){
			this.img = img;
			this.duration = duration;
			this.endTime = endTime;
		}

		public Image getImg() {
			return img;
		}

		public long getDuration() {
			return duration;
		}

		public long getEndTime() {
			return endTime;
		}
	}
}
