package com.jump.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Ryan.T on 11/21/17.
 */

public class Jumper {

    private final int jumpDown = -100;
    private final int jumpLeft = -75;
    private final int jumpRight = 75;
    private Vector2 velocity;
    private Vector2 position;
    private Texture jumper;
    private Sprite sprite;

    public Jumper() {
        jumper = new Texture("jumperDude.png");
        sprite = new Sprite(jumper);
        velocity = new Vector2(0, 0);
        position = new Vector2(0,0);
    }

    public void update(float dt) {

        /*if (position.y > 0) {
            velocity.add(0, jumpUp);
        }*/
        velocity.add(0, jumpDown);
        velocity.scl(dt);
        position.add(velocity.x * dt , velocity.y * dt);
        velocity.scl(1 / dt);

    }

    public void jump() {
        velocity.x = 2500;
        velocity.y = 15000;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getJumper() {
        return jumper;
    }
}
