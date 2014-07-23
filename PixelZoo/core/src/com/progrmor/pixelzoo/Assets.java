package com.progrmor.pixelzoo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static Texture texture, grassTx, block, blockH;
	public static TextureRegion grass, bg;
	
	public static Animation startAn;
	
	public static void load() {
		texture = new Texture(Gdx.files.internal("test.png"));
		grassTx = new Texture(Gdx.files.internal("ground.png"));
		grassTx.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		block = new Texture(Gdx.files.internal("blocks.png"));
		blockH = new Texture(Gdx.files.internal("blockH.png"));
		
		
		grass = new TextureRegion(grassTx, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		
	}
	public static void dispose() {
		texture.dispose();
	}
	
}
