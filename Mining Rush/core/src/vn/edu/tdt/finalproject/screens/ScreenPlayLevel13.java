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

public class ScreenPlayLevel13 extends AbstractScreen {

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


    public ScreenPlayLevel13(Application app) {
        super(app);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void show() {
        this.createCamera();
        createStageGame();
        PlayerInfo.setCurrentTarget(9700);
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


        lstAcRod.add(new ActorRod(375f, 25f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(842f, 285f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(122f, 278f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(658f, 372f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(677f, 107f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(300f, 270f, 60f, 50f, ActorRod.RodTag.ROCK_10));
        lstAcRod.add(new ActorRod(613f, 41f, 60f, 50f, ActorRod.RodTag.ROCK_10));

        lstAcRod.add(new ActorRod(788f, 110f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(74f, 202f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(232f, 112f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(714f, 352f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(411f, 258f, 60f, 50f, ActorRod.RodTag.ROCK_20));
        lstAcRod.add(new ActorRod(338f, 219f, 60f, 50f, ActorRod.RodTag.ROCK_20));

        lstAcRod.add(new ActorRod(160f, 67f, 60f, 50f, ActorRod.RodTag.GOLD_100));
        lstAcRod.add(new ActorRod(117f, 367f, 60f, 50f, ActorRod.RodTag.GOLD_100));

        lstAcRod.add(new ActorRod(256f, 184f, 60f, 50f, ActorRod.RodTag.GOLD_250));
        lstAcRod.add(new ActorRod(759f, 37f, 60f, 50f, ActorRod.RodTag.GOLD_250));

        lstAcRod.add(new ActorRod(905f, 193f, 80f, 80f, ActorRod.RodTag.GOLD_500));
        lstAcRod.add(new ActorRod(471f, 194f, 80f, 80f, ActorRod.RodTag.GOLD_500));

        lstAcRod.add(new ActorRod(568f, 234f, 25f, 25f, ActorRod.RodTag.EMERALD_100));
        lstAcRod.add(new ActorRod(622f, 209f, 25f, 25f, ActorRod.RodTag.EMERALD_100));

        lstAcRod.add(new ActorRod(55f, 296f, 25f, 25f, ActorRod.RodTag.RUBY_150));
        lstAcRod.add(new ActorRod(352f, 130f, 25f, 25f, ActorRod.RodTag.RUBY_150));

        lstAcRod.add(new ActorRod(34f, 340f, 25f, 25f, ActorRod.RodTag.SAPPHIRE_200));
        lstAcRod.add(new ActorRod(916f, 271f, 25f, 25f, ActorRod.RodTag.SAPPHIRE_200));

        lstAcRod.add(new ActorRod(727f, 222f, 25f, 25f, ActorRod.RodTag.AMETHYST_300));
        lstAcRod.add(new ActorRod(83f, 105f, 25f, 25f, ActorRod.RodTag.AMETHYST_300));
        lstAcRod.add(new ActorRod(517f, 92f, 25f, 25f, ActorRod.RodTag.AMETHYST_300));
        lstAcRod.add(new ActorRod(175f, 271f, 25f, 25f, ActorRod.RodTag.AMETHYST_300));

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
