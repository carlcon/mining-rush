package vn.edu.tdt.finalproject.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import vn.edu.tdt.finalproject.Application;
import vn.edu.tdt.finalproject.actors.ActorButton;
import vn.edu.tdt.finalproject.actors.ActorImage;
import vn.edu.tdt.finalproject.sounds.MusicEffect;
import vn.edu.tdt.finalproject.sounds.SoundEffect;
import vn.edu.tdt.finalproject.utils.PlayerInfo;
import vn.edu.tdt.finalproject.utils.ScreenConstants;
import vn.edu.tdt.finalproject.utils.SplashDoors;

public class MainMenuSettings extends AbstractScreen {

    private ScreenState screenState;
    private Texture background;
    private SoundEffect soundCloseDoor;
    private MusicEffect musicThugsLife;
    private long startTime;
    private long[] pauseTempTime;



    public MainMenuSettings(Application app) {
        super(app);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void show() {
        SplashDoors.setDoorClose();
        createCamera();
        createStageGame();
        app.batch.setProjectionMatrix(getCamera().combined);
        app.shapeBatch.setProjectionMatrix(getCamera().combined);
        background = new Texture("images/backgrounds/desertbackground.png");
        screenState = ScreenState.PLAY;


        soundCloseDoor = new SoundEffect("sounds/closedoor.ogg");
        soundCloseDoor.setSoundKind(SoundEffect.SoundKind.ONE_TIME);

        musicThugsLife = new MusicEffect("sounds/thugslife.ogg");
        musicThugsLife.setMusicKind(MusicEffect.MusicKind.DURING);
        musicThugsLife.playMusicLoopOnAndroid();

        startTime = TimeUtils.millis();
        pauseTempTime = new long[2];

        Gdx.input.setInputProcessor(getStageGame());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if(screenState.equals(ScreenState.PAUSE)){
            pauseTempTime[1] = TimeUtils.millis();
            if(pauseTempTime[1] - pauseTempTime[0] >=1000){
                pauseTempTime[0] = pauseTempTime[1];
                startTime += 1000;
            }
        }

        app.batch.begin();
        app.batch.draw(background,0,0,Application.DESKTOP_WIDTH,Application.DESKTOP_HEIGHT);
        SplashDoors.drawDoor(app.batch);
        app.batch.end();


        if(screenState.equals(ScreenState.FINISH)){
            SplashDoors.closeTheSplashDoor(10f);
            musicThugsLife.stopPlay();
            soundCloseDoor.playSound();
            if(SplashDoors.checkDoorClose() && TimeUtils.millis() - startTime >= 2000){
                if(PlayerInfo.getCurrentLevel() > ScreenConstants.PLAY_LEVEL_SCREEN.length){
                    app.gsm.setScreen(ScreenConstants.FINISH_SCREEN);
                }
                else {
                    app.gsm.setScreen(ScreenConstants.SHOP_SCREEN);
                }
                dispose();
            }
        }

        app.batch.begin();
        SplashDoors.drawDoor(app.batch);
        app.batch.end();
    }



    @Override
    public void pause() {
        screenState = ScreenState.PAUSE;
        musicThugsLife.pausePlay();
        pauseTempTime[0] = TimeUtils.millis();
    }

    @Override
    public void resume() {
        screenState = ScreenState.PLAY;
        musicThugsLife.resumePlay();
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        musicThugsLife.dispose();
        soundCloseDoor.dispose();
        super.dispose();
    }
}
