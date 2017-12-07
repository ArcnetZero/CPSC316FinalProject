package com.jump.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Ryan.T on 11/21/17.
 */

public class Jumper {

    private Sound swoosh;

    private final int Gravity = -350;
    private final int sideSpeed = 500;
    private final int jumpVelocity = 80000;


    private final int spriteSize = 150;
    private Vector2 velocity;
    private Vector2 position;
    private Texture jumper;
    private Sprite sprite;
    private Rectangle jumperBox;
    private boolean moveLeft;
    private boolean moveRight;
    //private Image jumper;

    public Jumper(float x, float y) {
        jumper = new Texture("jumperDude.png");
        sprite = new Sprite(jumper);
        jumperBox = new Rectangle(x, y, spriteSize, Math.round(getSpriteSize() * 1.34));
        velocity = new Vector2(0, 0);
        position = new Vector2(0, 0);
        swoosh = Gdx.audio.newSound(Gdx.files.internal("swoosh.mp3"));
    }

    public void update(float dt) {
        if(moveLeft){
            if(position.x<=0){
                position.x=0;
            }
            else {
                position.x -= sideSpeed * dt;
            }
        }
        if(moveRight){
            if(position.x>=(Gdx.graphics.getWidth()-spriteSize)){
                position.x=(Gdx.graphics.getWidth()-spriteSize);
            }
            else {
                position.x += sideSpeed * dt;
            }
        }
        if (position.y > 0) {
            velocity.add(0, Gravity);
        }
        velocity.add(0, Gravity);
        velocity.scl(dt);
        position.add(velocity.x, velocity.y * dt);
        jumperBox.setPosition(position.x, position.y);
        velocity.scl(1/dt);
    }

    public void setMoveLeft(boolean bool){
        moveLeft = bool;
        if(bool){
            moveRight = false;
        }
        else{
            moveRight = true;
        }
    }

    public void setMoveRight(boolean bool){
        moveRight = bool;
        if(bool){
            moveLeft = false;
        }
        else{
            moveLeft = true;
        }
    }

    public void jump(){

        velocity.y = jumpVelocity;
        swoosh.play();
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

    public int getSpriteSize() {

        return spriteSize;
    }

    public Rectangle getJumperBox() {

        return jumperBox;
    }

    public Vector2 getVelocity() {

        return velocity;
    }

    public Sound getSwoosh() {
        return swoosh;
    }
}
