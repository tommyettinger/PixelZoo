package com.progrmor.pixelzoo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.progrmor.screens.MainMenuScreen;

public class PixelZoo extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		font = new BitmapFont();
		Assets.load();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
		
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
		Assets.dispose();
	}
	
	
	
}
