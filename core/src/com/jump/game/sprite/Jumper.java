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
    private Vector2 velocity;
    private Vector2 position;
    private Texture jumper;
    private Sprite sprite;
    private boolean isFollowing;

    public Jumper() {
        isFollowing = false;
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
        if(isFollowing){
            position.add(Gdx.input.getX(),velocity.y * dt);
            velocity.scl(1/dt);
        }
        else{
            position.add(0,velocity.y * dt);
            velocity.scl(1/dt);
        }

    }

    public void isFollowing(boolean bool){
        isFollowing = bool;
    }
    public void jump() {
        position.x = Gdx.input.getX()-164;
        velocity.y = 7000;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getJumper() {
        return jumper;
    }
}
