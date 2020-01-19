package vn.edu.tdt.finalproject.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import vn.edu.tdt.finalproject.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Mining Rush";
		config.width = Application.DESKTOP_WIDTH;
		config.height = Application.DESKTOP_HEIGHT;
		config.addIcon("images/icons/gold.png", Files.FileType.Internal); // app icon
		new LwjglApplication(new Application(), config);
	}
}
