package com.jump.game.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jump.game.sprite.Jumper;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.jump.game.sprite.Platforms;

import java.util.ArrayList;

/**
 * Created by Ryan.T on 11/21/17.
 */

public class gameplay extends state  {

    private Jumper jumper;
    private int w, h;
    private Texture background;

    private int platformCount = 3;



    private Rectangle leftHalf;

    ArrayList<Platforms> platform;

    public gameplay(GameStateManager gsm) {
        super(gsm);
        jumper = new Jumper();
        background = new Texture("someRandomBackground.png");

        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        platform = new ArrayList<Platforms>();

        for(int i = 0; i < platformCount; i++) {

        }

    }


    @Override
    public void handleInput() {

        if (Gdx.input.justTouched()) {
            if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2){
                jumper.jump();
                jumper.jumpRight();
            } else {
                jumper.jump();
                jumper.jumpLeft();
            }
        }




    }


    @Override
    public void update(float dt) {
        handleInput();
        jumper.update(Gdx.graphics.getDeltaTime());
        cam.position.y = jumper.getPosition().y + 80;

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        sb.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(jumper.getJumper(), jumper.getPosition().x, jumper.getPosition().y, 200, 250);

        sb.end();


    }

    @Override
    public void dispose() {
        background.dispose();
        jumper.getJumperTex().dispose();


    }


}
