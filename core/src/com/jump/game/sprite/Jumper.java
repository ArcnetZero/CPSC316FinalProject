package com.jump.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Ryan.T on 11/21/17.
 */

public class Jumper {

    private final int Gravity = -100;
    private Vector2 velocity;
    private Vector2 position;
    private Texture jumper;
    private Sprite sprite;
    //private Image jumper;


    public Jumper() {
        jumper = new Texture("jumperDude.png");
        sprite = new Sprite(jumper);
        //jumper = new Image(new Texture(Gdx.files.internal("jumperDude.png")));
        velocity = new Vector2(0, 0);
        position = new Vector2(0, 0);
    }

    public void update(float dt) {

        if (position.y > 0) {
            velocity.add(0, Gravity);
        }
        velocity.add(0, Gravity);
        velocity.scl(dt);
        position.add(velocity.x, velocity.y * dt);
        velocity.scl(1/dt);
        }


    public void jump(){
        velocity.y = 18000;
    }

    public void jumpLeft(){
        velocity.x =  -50;
    }

    public void jumpRight() {
        velocity.x = 50;
    }

    public Vector2 getPosition(){
        return position;
    }

    public Sprite getJumper(){
        return sprite;
    }

    public Texture getJumperTex() {
        return jumper;
    }
}
