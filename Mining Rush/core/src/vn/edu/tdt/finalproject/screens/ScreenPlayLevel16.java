package vn.edu.tdt.finalproject.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.HashMap;

import vn.edu.tdt.finalproject.Application;
import vn.edu.tdt.finalproject.actors.ActorButton;
import vn.edu.tdt.finalproject.actors.ActorHuman;
import vn.edu.tdt.finalproject.actors.ActorRod;
import vn.edu.tdt.finalproject.actors.ActorText;
import vn.edu.tdt.finalproject.miniscreens.MiniScreenState;
import vn.edu.tdt.finalproject.miniscreens.SettingDisplay;
import vn.edu.tdt.finalproject.miniscreens.TargetDisplay;
import vn.edu.tdt.finalproject.miniscreens.TimeOutDisplay;
import vn.edu.tdt.finalproject.utils.GameMethods;
import vn.edu.tdt.finalproject.utils.PlayerInfo;
import vn.edu.tdt.finalproject.utils.ScreenConstants;
import vn.edu.tdt.finalproject.utils.SplashDoors;
import vn.edu.tdt.finalproject.utils.TextConstants;

public class ScreenPlayLevel16 extends AbstractScreen {

    private ActorHuman acHuman;
    private ArrayList<ActorRod> lstAcRod;
    private ActorButton shootButton;
    private ActorButton boomButton;
    private Texture background;
    private long startTime;
    private long pauseTempTime[];
    private HashMap<ActorText.TextTag,ActorText> lstAcText;
    private Stage stageSetting;
    private TargetDisplay targetDisplay;
    private SettingDisplay settingDisplay;
    private ActorButton settingButton;
    private TimeOutDisplay timeOutDisplay;


    public ScreenPlayLevel16(Application app) {
        super(app);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void show() {
        this.createCamera();
        createStageGame();
        PlayerInfo.setCurrentTarget(16000);
        //stage.setDebugAll(true);

        app.batch.setProjectionMatrix(getCamera().combined);
        app.shapeBatch.setProjectionMatrix(getCamera().combined);
        background = new Texture("images/backgrounds/ingame_background.png");

        startTime = TimeUtils.millis()/1000;
        pauseTempTime = new long[2];

        lstAcRod = new ArrayList<ActorRod>();
        lstAcText = new HashMap<ActorText.TextTag, ActorText>();


        acHuman = new ActorHuman();
        shootButton = new ActorButton(128f,128f, ActorButton.ButtonTag.SHOOT);
        boomButton = new ActorButton(128f, 128f, ActorButton.ButtonTag.BOOM);
        settingButton = new ActorButton(100f, 100f, ActorButton.ButtonTag.SETTING);

        lstAcRod.add(new ActorRod(361f, 298f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(581f, 298f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(54f, 84f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(567f, 136f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(398f, 150f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(831f, 288f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(165f, 298f, 60f, 50f, ActorRod.RodTag.ROCK_10));

        lstAcRod.add(new ActorRod(281f, 343f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(480f, 343f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(681f, 343f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(352f, 50f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(648f, 50f, 60f, 50f, ActorRod.RodTag.ROCK_20));

        lstAcRod.add(new ActorRod(723f, 120f, 60f, 50f, ActorRod.RodTag.GOLD_250));
        lstAcRod.add(new ActorRod(256f, 120f, 60f, 50f, ActorRod.RodTag.GOLD_250));

        lstAcRod.add(new ActorRod(479f, 61f, 80f, 80f, ActorRod.RodTag.GOLD_500));
        lstAcRod.add(new ActorRod(894f, 210f, 80f, 80f, ActorRod.RodTag.GOLD_500));
        lstAcRod.add(new ActorRod(68f, 210f, 80f, 80f, ActorRod.RodTag.GOLD_500));

        lstAcRod.add(new ActorRod(152f, 89f, 25f, 25f, ActorRod.RodTag.EMERALD_100));
        lstAcRod.add(new ActorRod(827f, 101f, 25f, 25f, ActorRod.RodTag.EMERALD_100));

        lstAcRod.add(new ActorRod(44f, 363f, 25f, 25f, ActorRod.RodTag.RUBY_150));
        lstAcRod.add(new ActorRod(931f, 363f, 25f, 25f, ActorRod.RodTag.RUBY_150));

        lstAcRod.add(new ActorRod(131f, 324f, 25f, 25f, ActorRod.RodTag.SAPPHIRE_200));
        lstAcRod.add(new ActorRod(883f, 331f, 25f, 25f, ActorRod.RodTag.SAPPHIRE_200));

        lstAcRod.add(new ActorRod(164f, 169f, 25f, 25f, ActorRod.RodTag.AMETHYST_300));
        lstAcRod.add(new ActorRod(804f, 182f, 25f, 25f, ActorRod.RodTag.AMETHYST_300));

        lstAcRod.add(new ActorRod(199f, 251f, 25f, 25f, ActorRod.RodTag.DIAMOND_650));
        lstAcRod.add(new ActorRod(769f, 251f, 25f, 25f, ActorRod.RodTag.DIAMOND_650));
        lstAcRod.add(new ActorRod(330f, 228f, 25f, 25f, ActorRod.RodTag.DIAMOND_650));
        lstAcRod.add(new ActorRod(631f, 225f, 25f, 25f, ActorRod.RodTag.DIAMOND_650));
        lstAcRod.add(new ActorRod(478f, 205f, 25f, 25f, ActorRod.RodTag.DIAMOND_650));

        GameMethods.createPlayScreenActorText(getStageGame(), lstAcRod, lstAcText);

        getStageGame().addActor(acHuman);
        getStageGame().addActor(acHuman.getAcPod());
        getStageGame().addActor(acHuman.getAcBomb());
        for (ActorRod rod: lstAcRod){
            if(rod != null){
                getStageGame().addActor(rod);
            }
        }
        getStageGame().addActor(shootButton);
        getStageGame().addActor(boomButton);
        getStageGame().addActor(settingButton);
        // stage.addActor(textTime);


        stageSetting = new Stage();
        stageSetting.setViewport(new ScreenViewport(getCamera()));
        targetDisplay = new TargetDisplay();

        settingDisplay = new SettingDisplay();

        timeOutDisplay = new TimeOutDisplay();

        stageSetting.addActor(targetDisplay);
        stageSetting.addActor(settingDisplay);
        stageSetting.addActor(timeOutDisplay);

        Gdx.input.setInputProcessor(getStageGame());
        Gdx.input.setInputProcessor(stageSetting);

        setScreenState(ScreenState.PAUSE);

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        app.batch.begin();
        app.batch.draw(background,0,0,Application.DESKTOP_WIDTH,Application.DESKTOP_HEIGHT);
        SplashDoors.drawDoor(app.batch);
        app.batch.end();

        if(getScreenState().equals(ScreenState.PAUSE)){
            pauseTempTime[1] = TimeUtils.millis()/1000;
            if(pauseTempTime[1] - pauseTempTime[0] >=1){
                pauseTempTime[0] = pauseTempTime[1];
                startTime += 1;
                TextConstants.setTakingStartTimeShow(TextConstants.getTakingStartTimeShow() + 1);
            }
            //targetDisplay
            if(targetDisplay.getMiniScreenState().equals(MiniScreenState.HIDE)){
                resumeCustom();
                targetDisplay.setMiniScreenState(MiniScreenState.FINISH);
            }
            //settingDisplay
            settingButton.updateButtonTouched();
            if(settingDisplay.isResume()){
                resumeCustom();
                settingDisplay.setResume(false);
            }
            if(settingDisplay.isBackMainMenu()){
                if(SplashDoors.checkDoorClose()){
                    app.gsm.setScreen(ScreenConstants.MAINMENU_SCREEN);
                    dispose();
                }
            }

            if(timeOutDisplay.getMiniScreenState().equals(MiniScreenState.FINISH)){
                GameMethods.goWinOrLoseScreen(this, app.gsm);
            }
            stageSetting.act();
            stageSetting.draw();
        }



        if(getScreenState().equals(ScreenState.PLAY)) {

            getStageGame().act();

            if (!GameMethods.checkTimePlay(lstAcText, startTime)
                    || GameMethods.isCatchedAllRod(lstAcRod)) {
                if(timeOutDisplay.getMiniScreenState().equals(MiniScreenState.HIDE)){
                    timeOutDisplay.showDisplay();
                    pause();
                }
            }

            GameMethods.updateBombNumber(lstAcText);

            GameMethods.updateRodCollisionEvent(acHuman.getAcPod(), acHuman.getAcBomb(), lstAcRod, lstAcText, boomButton);

            GameMethods.updatePodToShoot(acHuman.getAcPod(), shootButton, boomButton);

            GameMethods.updateSoundTargetSuccess(lstAcText);

            settingButton.updateButtonTouched();
            if(settingButton.isTouched()){
                settingDisplay.showDisplay();
                pause();
            }

            acHuman.updateAnimationState();
            getStageGame().draw();
        }
    }

    @Override
    public void pause() {
        System.out.println(TimeUtils.millis()/1000);
        pauseTempTime[0] = TimeUtils.millis()/1000;
        acHuman.getAcPod().muteAllSound();
        setScreenState(ScreenState.PAUSE);
        if(targetDisplay.getMiniScreenState().equals(MiniScreenState.FINISH)
                && timeOutDisplay.getMiniScreenState().equals(MiniScreenState.HIDE)){
            settingDisplay.showDisplay();
        }
        GameMethods.pauseTimerSound(lstAcText);
    }

    private void resumeCustom(){
        acHuman.getAcPod().unmuteAllSound();
        setScreenState(ScreenState.PLAY);
        GameMethods.resumeTimerSound(lstAcText);
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        PlayerInfo.getBag().resetBag();
        background.dispose();
        if(acHuman != null) {
            acHuman.remove();
        }
        settingButton.remove();
        settingDisplay.remove();
        timeOutDisplay.remove();
        targetDisplay.remove();
        boomButton.remove();
        shootButton.remove();
        GameMethods.disposeAllText(lstAcText);
        GameMethods.disposeAllRod(lstAcRod);
        stageSetting.dispose();
        super.dispose();
    }
}
