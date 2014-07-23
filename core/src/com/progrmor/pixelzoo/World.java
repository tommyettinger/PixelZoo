package com.progrmor.pixelzoo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.progrmor.pixelzoo.characters.StarterChar;



public class World {

	private StarterChar sc;
	private ScrollHandler scroller;
	private World world;
	private int score = 0;
	
	private int midPointY;

	/* private GameState currentState;
		public enum GameState {
			READY, RUNNING, GAMEOVER
		} */
		
	
	public World(int midPointY) {
		
		//currentState = GameState.READY;
		sc = new StarterChar(33, midPointY -5, 17, 12);
		scroller = new ScrollHandler(midPointY + 66);
		
		this.midPointY = midPointY;
	}
	
	
	public void update(float delta) {
		/*switch(currentState) {
		case READY:
			updateReady(delta);
			break;
		case RUNNING:
			default:
				updateRunning(delta);
				break;
		}*/
	}
	
	public void updateRunning(float delta) {
		
		sc.update(delta);
		scroller.update(delta);
		
		/*if(scroller.collides(sc) && sc.isAlive()) {
			scroller.stop();
			sc.die();
			Assets.dead.play();
		}*/
		
		
		
		
	}
	
	public void updateReady(float delta) {
		
	}
	/*public boolean isReady() {
		return currentState == GameState.READY;
	}
	public void start() {
		currentState = GameState.RUNNING;
	}
	
	public void restart() {
		currentState = GameState.READY;
		score = 0;
		sc.onRestart(midPointY - 5);
		scroller.onRestart();
		currentState = GameState.READY;
	}
	public boolean isGameOver()	 {
		return currentState == GameState.GAMEOVER;
	}*/
	
	public StarterChar getChar() {
		return sc;
	}
	public ScrollHandler getScroller()	{
		return scroller;
	}
	
	public int  getScore()	{
		return score;
	}
	public void addScore(int increment)	{
		score += increment;
	}
	
	
	
}
