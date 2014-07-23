package com.progrmor.pixelzoo;

import java.util.Random;

import com.progrmor.pixelzoo.characters.Block;

public class ScrollHandler {
	
	private Grass frontGrass, backGrass;
	private Block block1, block2, block3, block4;
	
	public static final int SCROLL_SPEED = -79;
	public static int BLOCK_GAP = 150;
	
	
	public ScrollHandler(float yPos) {
		
		
		yPos = 30f;
		frontGrass = new Grass(0, yPos, 800, 11, SCROLL_SPEED);
		backGrass = new Grass(frontGrass.getTailX(), yPos, 800, 11, SCROLL_SPEED);
		
		block1 = new Block(500, yPos + 5, 22, 60, SCROLL_SPEED);
		block2  = new Block(block1.getTailX() + BLOCK_GAP + 100, yPos + 5, 22, 70, SCROLL_SPEED);
		block3  = new Block(block1.getTailX() + BLOCK_GAP + 100, yPos + 5, 22, 60, SCROLL_SPEED);
		block4  = new Block(block1.getTailX() + BLOCK_GAP + 100, yPos + 5, 22, 60, SCROLL_SPEED);
	}
	
	public void update(float delta) {
		frontGrass.update(delta);
		backGrass.update(delta);
		block1.update(delta);
		block2.update(delta);
		block3.update(delta);
		block4.update(delta);
		
		if(block1.isScrolledLeft()) {
			block1.reset(block3.getTailX() + BLOCK_GAP);
			
		} else if(block2.isScrolledLeft()) {
			block2.reset(block1.getTailX() + BLOCK_GAP);
		} else if(block3.isScrolledLeft()) {
			block3.reset(block2.getTailX() + BLOCK_GAP);
		}else if(block4.isScrolledLeft()) {
			block4.reset(block3.getTailX() + BLOCK_GAP);
		}
		
		if(frontGrass.isScrolledLeft()) {
			frontGrass.reset(backGrass.getTailX());
			
		} else if(backGrass.isScrolledLeft()) {
			backGrass.reset(frontGrass.getTailX());
		}
		
	}
	
	public void onRestart()	 {
		frontGrass.onRestart(0, SCROLL_SPEED);
		backGrass.onRestart(frontGrass.getTailX(), SCROLL_SPEED);
		block1.onRestart(500, SCROLL_SPEED);
		block2.onRestart(block1.getTailX() + BLOCK_GAP, SCROLL_SPEED );
		block3.onRestart(block2.getTailX() + BLOCK_GAP , SCROLL_SPEED);
		block4.onRestart(block3.getTailX() + BLOCK_GAP, SCROLL_SPEED);
		
	}
	
	public Grass getFrontGrass() {
		return frontGrass;
	}
	
	public Grass getBackGrass() {
		return backGrass;
	}
	
	public Block getBlock1()	 {
		return block1;
	}
	public Block getBlock2() {
		return block2;
	}
	public Block getBlock3()	 {
		return block3;
	}
	public Block getBlock4() {
		return block4;
	}
}
