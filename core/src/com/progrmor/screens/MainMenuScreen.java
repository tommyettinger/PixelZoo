package com.progrmor.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.progrmor.pixelzoo.PixelZoo;

public class MainMenuScreen implements Screen{

	
	final PixelZoo game;
	
	
	
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonStart, btnChange, btnOpt, btnStore;
	private BitmapFont font;
	private Label label;
	private TextButtonStyle textButtonStyle;
	private Thread thr;
	
	OrthographicCamera camera;
	
	
	
	//***************************************************
	//*************************************************
	public MainMenuScreen(final PixelZoo gam) {
		game = gam;
		
		
		
		
		thr = new Thread();
		
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
        
        /*if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }*/
        
        
        buttonStart.addListener(new ChangeListener() {

    		@Override
    		public void changed(ChangeEvent event, Actor actor) {
    			// TODO Auto-generated method stub
    			
    			game.setScreen(new GameScreen(game));
    		}
        });
        
        btnOpt.addListener(new ChangeListener() {

    		@Override
    		public void changed(ChangeEvent event, Actor actor) {
    			// TODO Auto-generated method stub
    			game.setScreen(new OptionsScreen(game));
    		}
        });
    		
    	
		
	}
	
	

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		{
			
			
		}
		
		atlas = new TextureAtlas(Gdx.files.internal("buttons.pack"));
		skin = new Skin(atlas);
		font = new BitmapFont();
		
		table = new Table();
		table.setBounds(100, 400, 500, 400);
		
		TextButtonStyle tbStyle = new TextButtonStyle();
		skin.addRegions(atlas);
		tbStyle.up = skin.getDrawable("buttonpressed");
		tbStyle.down = skin.getDrawable("button");
		tbStyle.font = font;
		tbStyle.pressedOffsetX = -1;
		tbStyle.pressedOffsetY = -1;
		
		
		tbStyle.font = font;
		tbStyle.font.setScale(3, 3);
		//tbStyle.font = ;
		
		//*****************************
		//Buttons
		//*******
		buttonStart = new TextButton("Play!", tbStyle);
		
		
		btnChange = new TextButton("Character", tbStyle);
		
		
		btnOpt = new TextButton("Options", tbStyle);
		
		btnStore = new TextButton("Store", tbStyle);
		
		
		//****************
		//Setting up the buttons in a table
		//******************
		
		table.add(buttonStart).pad(20).size(350, 200).row();
		table.add(btnChange).pad(20).size(350, 200).row();
		table.add(btnOpt).pad(20).size(350, 200).row();
		table.add(btnStore).pad(20).size(350, 200).row();
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
