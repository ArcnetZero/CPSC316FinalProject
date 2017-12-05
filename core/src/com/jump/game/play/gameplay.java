package com.jump.game.play;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.jump.game.JumpGame;
import com.jump.game.play.*;
import com.jump.game.sprite.Platforms;
import com.jump.game.sprite.Jumper;
import com.badlogic.gdx.utils.Array;
import java.util.Random;

import java.util.ArrayList;

/**
 * Created by Ryan.T on 11/21/17.
 */

public class gameplay extends state implements InputProcessor {

    private Random rand;
    private Jumper jumper;
    //private Platforms platform;
    private Array<Platforms> platforms;
    private int platformCount = 3;
    private Rectangle intersection;

    public gameplay(GameStateManager gsm) {
        super(gsm);

        rand = new Random();
        jumper = new Jumper(0,0);
        platforms = new Array<Platforms>();
        intersection = new Rectangle();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for(int i = 0; i < platformCount; i++) {
            platforms.add(new Platforms(jumper.getPosition().x + i*rand.nextInt(Gdx.graphics.getWidth()), jumper.getPosition().y + i * rand.nextInt(Gdx.graphics.getWidth()) - 10));
        }

    }


    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            //Do nothing
        }
    }

    @Override
    public void update(float dt) {
        //System.out.println(jumper.getJumperBox().x);
        cam.position.y = jumper.getPosition().y;
        handleInput();
        touchDown(Gdx.input.getX(), Gdx.input.getY(), 0, 0);
        touchUp(Gdx.input.getX(), Gdx.input.getY(), 0, 0);
        jumper.update(Gdx.graphics.getDeltaTime());


        for (Platforms platform : platforms) {
            if (cam.position.y - ((cam.viewportHeight / 2) + Platforms.cloud_HEIGHT) > platform.getCloudPos().y) {
                platform.reposition(cam.position.y);
            }


            if(Intersector.intersectRectangles(jumper.getJumperBox(), platform.getCloudBox(), intersection ))
            {
                if(intersection.y > platform.getCloudBox().y && jumper.getVelocity().y < 0)
                    jumper.jump();
            }

        }




        cam.update();
    }


    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);

        sb.begin();

        sb.draw(jumper.getJumper(), jumper.getPosition().x, jumper.getPosition().y, jumper.getSpriteSize(), Math.round(jumper.getSpriteSize() * 1.34));
        for(Platforms platform: platforms) {
            sb.draw(platform.getClouds(), platform.getCloudPos().x, platform.getCloudPos().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        for(Platforms platform: platforms) {
            platform.getClouds().dispose();
        }
        jumper.getJumperTex().dispose();

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (Gdx.input.getX() >= Gdx.graphics.getWidth() / 2) {
            jumper.setMoveLeft(true);
        } else {

            jumper.setMoveRight(true);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (Gdx.input.getX() >= Gdx.graphics.getWidth() / 2) {
            jumper.setMoveLeft(false);
        } else {
            jumper.setMoveRight(false);
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}