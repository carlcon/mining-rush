package vn.edu.tdt.finalproject.managers;

import java.util.HashMap;

import vn.edu.tdt.finalproject.Application;
import vn.edu.tdt.finalproject.screens.AbstractScreen;
import vn.edu.tdt.finalproject.screens.FinishScreen;
import vn.edu.tdt.finalproject.screens.LoseScreen;
import vn.edu.tdt.finalproject.screens.MainMenuHow;
import vn.edu.tdt.finalproject.screens.MainMenuScreen;
import vn.edu.tdt.finalproject.screens.MainMenuSettings;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel1;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel10;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel11;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel12;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel13;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel14;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel15;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel16;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel2;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel3;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel4;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel5;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel6;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel7;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel8;
import vn.edu.tdt.finalproject.screens.ScreenPlayLevel9;
import vn.edu.tdt.finalproject.screens.ScreenTest;
import vn.edu.tdt.finalproject.screens.ShopScreen;
import vn.edu.tdt.finalproject.screens.WinScreen;
import vn.edu.tdt.finalproject.utils.ScreenConstants;

public class GameScreenManager {
    public final Application app;

    private AbstractScreen gameScreen;

    public GameScreenManager(final Application app){
        this.app = app;

        setScreen(ScreenConstants.MAINMENU_SCREEN);

    }

    public AbstractScreen getNextScreen(int level){
        gameScreen = null;
        if(level == ScreenConstants.WIN_SCREEN){
            gameScreen = new WinScreen(this.app);
        }
        if(level == ScreenConstants.LOSE_SCREEN){
            gameScreen = new LoseScreen(this.app);
        }
        if(level == ScreenConstants.FINISH_SCREEN){
            gameScreen = new FinishScreen(this.app);
        }
        if(level == ScreenConstants.SHOP_SCREEN){
            gameScreen = new ShopScreen(this.app);
        }
        if(level == ScreenConstants.MAINMENU_SCREEN){
            gameScreen = new MainMenuScreen(this.app);
        }
        if(level == ScreenConstants.MAINMENU_SETTINGS){
            gameScreen = new MainMenuSettings(this.app);
        }
        if(level == ScreenConstants.MAINMENU_HOW){
            gameScreen = new MainMenuHow(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[0]){
            gameScreen = new ScreenPlayLevel1(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[1]){
            gameScreen = new ScreenPlayLevel2(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[2]){
            gameScreen = new ScreenPlayLevel3(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[3]){
            gameScreen = new ScreenPlayLevel4(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[4]){
            gameScreen = new ScreenPlayLevel5(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[5]){
            gameScreen = new ScreenPlayLevel6(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[6]){
            gameScreen = new ScreenPlayLevel7(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[7]){
            gameScreen = new ScreenPlayLevel8(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[8]){
            gameScreen = new ScreenPlayLevel9(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[9]){
            gameScreen = new ScreenPlayLevel10(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[10]){
            gameScreen = new ScreenPlayLevel11(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[11]){
            gameScreen = new ScreenPlayLevel12(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[12]){
            gameScreen = new ScreenPlayLevel13(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[13]){
            gameScreen = new ScreenPlayLevel14(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[14]){
            gameScreen = new ScreenPlayLevel15(this.app);
        }
        if(level == ScreenConstants.PLAY_LEVEL_SCREEN[15]){
            gameScreen = new ScreenPlayLevel16(this.app);
        }

        return gameScreen;
    }

    public void setScreen(int level){
        app.setScreen(getNextScreen(level));
    }

    public void dispose(){

    }
}
