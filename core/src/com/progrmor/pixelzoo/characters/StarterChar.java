package com.progrmor.pixelzoo.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class StarterChar {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	
	private float rotation;
	private int width;
	private int height;
	
	private boolean isAlive;
	
	
	
	public StarterChar(float x, float y, int width, int height) {
		
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0,0);
		acceleration = new Vector2(0, -600);
		isAlive = true;
	}
	
	
	public void update(float delta) {
		velocity.add(acceleration.cpy().scl(delta));
		
		
		position.add(velocity.cpy().scl(delta));
		
		
	
		
	}
	
	public void die()	 {
		isAlive = false;
		velocity.y = 0;
	}
	
	
	
	public void onClick() {
		/*if(isAlive) {
			velocity.y = 390;	
		}*/
		velocity.y = 390;
		
		
	}
	
	

	public void onRestart(int y) {
		rotation = 0;
		position.y = y;
		position.x = 0;
		velocity.x = 0;
		velocity.y = 0;
		acceleration.x = 0;
		acceleration.y = -600;
		isAlive = true;
	}
	
	
	public float getX() {
		return position.x;
	}
	public float getY()	 {
		return position.y;
	}
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
	public float getRotation() {
		return rotation;
	}
	public boolean isAlive() {
		return isAlive;
	}
	
}
