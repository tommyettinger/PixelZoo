package com.progrmor.pixelzoo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.progrmor.pixelzoo.PixelZoo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "RacingZoo";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new PixelZoo(), config);
	}
}
