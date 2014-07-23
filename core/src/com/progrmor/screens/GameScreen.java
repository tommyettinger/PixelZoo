package com.progrmor.screens;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.progrmor.pixelzoo.Assets;
import com.progrmor.pixelzoo.Grass;
import com.progrmor.pixelzoo.InputHandler;
import com.progrmor.pixelzoo.PixelZoo;
import com.progrmor.pixelzoo.ScrollHandler;
import com.progrmor.pixelzoo.World;

import com.progrmor.pixelzoo.characters.Block;
import com.progrmor.pixelzoo.characters.StarterChar;

public class GameScreen implements Screen{

	final PixelZoo game;
	OrthographicCamera camera;
	private int midPointY;
	World world;
	StarterChar sc;
	ScrollHandler scroller;
	Grass frontGrass, backGrass;
	Block block1, block2, block3, block4;
	
	
	int score = 0;
	
	 
	
	
	

	
	
	
	Random rnd;
	
	private Texture grass, blocks, blockH, scTex;
	
	public GameScreen(final PixelZoo gam) {
		this.game = gam;
		
		// create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        
        
        midPointY = (int) (480 / 2);
        initAssets();
        world = new World(midPointY);
        
        
        sc  = new StarterChar(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
        Gdx.input.setInputProcessor(new InputHandler(world.getChar()));
	}
	
	
	
	
	
	public void updateRunning(float delta) {
		if(delta > .15f) {
			delta = .15f;
		}
		
		sc.update(delta);
		scroller.update(delta);
	}
	
	public void updateReady(float delta) {
		
	}
	
	public ScrollHandler getScroller()	 {
		return scroller;
	}
	
	public StarterChar getChar() {
		return sc;
	}
	
	private void initGameObjects() {
		sc = world.getChar();
		scroller = world.getScroller();
		frontGrass = scroller.getFrontGrass();
		backGrass = scroller.getBackGrass();
		block1 = scroller.getBlock1();
		block2 = scroller.getBlock2();
		block3 = scroller.getBlock3();
		block4 = scroller.getBlock4();
		
					
	}
	private void initAssets() {
		grass = Assets.grassTx;
		blocks = Assets.block;
		blockH = Assets.blockH;
		scTex = Assets.texture;
		
	}
	private void drawGrass() {
		
		game.batch.draw(grass, backGrass.getX(), backGrass.getY(), backGrass.getWidth(), backGrass.getHeight());
		game.batch.draw(grass, frontGrass.getX(), frontGrass.getY(), frontGrass.getWidth(), frontGrass.getHeight());
		//game.batch.draw(blocks, block1.getX(), block1.getY(), 10, 10);
		
	}
	private void drawBlocks() {
		game.batch.draw(blocks, block1.getX(), block1.getY(), block1.getWidth(), block1.getHeight());
		game.batch.draw(blockH, block2.getX(), block2.getY(), block2.getWidth(), block2.getHeight());
		game.batch.draw(blocks, block3.getX(), block3.getY(), block3.getWidth(), block3.getHeight());
		game.batch.draw(blocks, block4.getX(), block4.getY(), block4.getWidth(), block4.getHeight());
		
	}
	
	private void drawCharacter() {
		game.batch.draw(scTex, sc.getX(), sc.getY(), sc.getWidth(), sc.getHeight());
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        camera.update();
        //world.update(delta);
        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);
        initAssets();
        initGameObjects();
        game.batch.begin();
        
        //game.batch.draw(Assets.grass, 0, midPointY - 150, 800, 32);
        drawCharacter();
        drawGrass();
        drawBlocks();
        
        
        game.batch.end();
		
	}
	
	

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
