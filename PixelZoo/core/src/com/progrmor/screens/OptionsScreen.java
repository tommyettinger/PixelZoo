package com.progrmor.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.progrmor.pixelzoo.PixelZoo;

public class OptionsScreen implements Screen{
	final PixelZoo game;
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton btnSound, btnOff, btnBack;
	private BitmapFont font;
	private Label label;
	private TextButtonStyle textButtonStyle;
	
	OrthographicCamera camera;
	
	public OptionsScreen(final PixelZoo gam)	{
		
		game = gam;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		
		
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        
        game.batch.begin();
        
        //Table.drawDebug(stage);
        
        stage.act(delta);
        stage.draw();
        //stage.draw();
        
        game.batch.end();
		
		
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		
stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		{
			
			
		}
		
		atlas = new TextureAtlas(Gdx.files.internal("OpButtons.pack"));
		skin = new Skin(atlas);
		font = new BitmapFont();
		
		table = new Table();
		table.setBounds(50, 250, 100, 50);
		
		TextButtonStyle tbStyle = new TextButtonStyle();
		skin.addRegions(atlas);
		tbStyle.up = skin.getDrawable("sound");
		tbStyle.down = skin.getDrawable("soundOff");
		tbStyle.font = font;
		tbStyle.pressedOffsetX = -1;
		tbStyle.pressedOffsetY = -1;
		
		tbStyle.font = font;
		//tbStyle.font = ;
		
		//*****************************
		//Buttons
		//*******
		btnSound = new TextButton("", tbStyle);
		
		
		btnOff = new TextButton("Character", tbStyle);
		btnOff.pad(20);
		
		btnBack = new TextButton("Options", tbStyle);
		
		
		
		
		//****************
		//Setting up the buttons in a table
		//******************
		table.add(btnSound).row().pad(10);
		
		//table.debug();
		stage.addActor(table);
		
		
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
