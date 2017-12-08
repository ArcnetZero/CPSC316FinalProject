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

/**
 * Created by Ryan.T on 11/21/17.
 */

public class Jumper {

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
    private boolean moveStop = false;
    //private Image jumper;

    public Jumper(float x, float y) {
        jumper = new Texture("jumperDude.png");
        sprite = new Sprite(jumper);
        jumperBox = new Rectangle(x, y, spriteSize, Math.round(getSpriteSize() * 1.34));
        velocity = new Vector2(0, 0);
        position = new Vector2((Gdx.graphics.getWidth()-spriteSize)/2, 100);
    }

    public void update(float dt) {
        System.out.println(moveLeft);
        System.out.println(moveRight);
        System.out.println(moveStop);
        if(moveLeft){
            sprite.setFlip(true, false);
            if(position.x<=0){
                position.x=0;
            }
            else {
                if(position.x - Gdx.input.getX() < sideSpeed/4)
                    position.x -= (position.x - Gdx.input.getX())*dt;
                else
                    position.x -= sideSpeed*dt;
            }
        }
        else if(moveRight){
            sprite.setFlip(false,false);
            if(position.x>=(Gdx.graphics.getWidth()-spriteSize)){
                position.x=(Gdx.graphics.getWidth()-spriteSize);
            }
            else {
                if(Gdx.input.getX()- position.x < sideSpeed/4)
                    position.x += (Gdx.input.getX()- position.x)*dt;
                else
                    position.x += sideSpeed*dt;
            }
        }
        else if(moveStop){
            velocity.x = 0;
        }
        if (position.y > 0) {
            velocity.add(0, Gravity);
        }
        velocity.add(0, Gravity);
        velocity.scl(dt);
        position.add(velocity.x*dt, velocity.y * dt);
        jumperBox.setPosition(position.x, position.y);
        velocity.scl(1/dt);
    }

    public void setMoveLeft(boolean bool){
        moveLeft = bool;
    }

    public void setMoveRight(boolean bool){
        moveRight = bool;
    }

    public void setMoveStop(boolean bool){
        moveStop = bool;
    }

    public void jump(){

        velocity.y = jumpVelocity;
    }

    public Vector2 getPosition(){

        return position;
    }
    public float getXPosition(){

        return position.x;
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
}
