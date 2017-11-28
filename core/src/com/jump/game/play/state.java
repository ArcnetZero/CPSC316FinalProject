package com.jump.game.play;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Ryan.T on 11/21/17.
 */



    public abstract class state {
    protected OrthographicCamera cam;
    protected GameStateManager gsm;

    public state(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();


}

