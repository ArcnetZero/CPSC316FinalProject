package com.jump.game.play;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jump.game.JumpGame;
import com.jump.game.play.*;
import com.jump.game.sprite.*;
import com.jump.game.sprite.Jumper;

/**
 * Created by Ryan.T on 11/21/17.
 */

public class gameplay extends state implements ApplicationListener, InputProcessor {

    private Jumper jumper;

    public gameplay(GameStateManager gsm) {
        super(gsm);
        jumper = new Jumper();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            jumper.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        touchDown(Gdx.input.getX(), Gdx.input.getY(), 0, 0);
        touchUp(Gdx.input.getX(), Gdx.input.getY(), 0, 0);
        jumper.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(jumper.getJumper(), jumper.getPosition().x, jumper.getPosition().y, jumper.getSpriteSize(), Math.round(jumper.getSpriteSize() * 1.34));
        sb.end();
    }

    @Override
    public void create() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

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