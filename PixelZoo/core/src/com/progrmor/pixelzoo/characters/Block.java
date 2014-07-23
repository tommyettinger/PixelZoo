package com.progrmor.pixelzoo.characters;

import java.util.Random;

import com.progrmor.pixelzoo.Scrollable;

public class Block extends Scrollable{

	private Random r;
	
	public Block(float x, float y, int width, int height, float scrollSpeed) {
		super(x, y, width, height, scrollSpeed);
		r = new Random();
		
	}

	@Override
	public void reset(float newX) {
		// TODO Auto-generated method stub
		super.reset(newX);
		
		height = r.nextInt(90);
		//width = r.nextInt(60);
	}
	public void onRestart(float x, float scrollSpeed) {
		velocity.x = scrollSpeed;
		reset(x);
	}
	
	
	
}
