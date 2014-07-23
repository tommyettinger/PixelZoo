package com.progrmor.pixelzoo;

import com.badlogic.gdx.InputProcessor;
import com.progrmor.pixelzoo.characters.StarterChar;
import com.progrmor.screens.GameScreen;

public class InputHandler implements InputProcessor{
	//MySc == My starter character
	private StarterChar MySc;
	private World world;
	
	
	
	
	
	public InputHandler(StarterChar MySc) {
		this.world = world;
		this.MySc = MySc;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
/*
		if(world.isReady()) {
			world.start();
		}*/
		
		
		MySc.onClick();
		
	/*	if(world.isGameOver()) {
			//reset all variables, go to GAMESTATE.READY
			world.restart();
		}*/
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public StarterChar getChar() {
		return MySc;
	}

}
