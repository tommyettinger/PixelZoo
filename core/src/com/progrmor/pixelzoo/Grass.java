package com.progrmor.pixelzoo;

public class Grass extends Scrollable{
	
	//When Grass´s constructor is invoken, invoke the super
	public Grass(float x, float y, int width, int height, float scrollSpeed) {
		super(x, y, width , height, scrollSpeed);
	}
	public void onRestart(float x, float scrollSpeed) {
		position.x = x;
		position.x = scrollSpeed;
	}
	
}
