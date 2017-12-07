package com.jump.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.awt.Color;
import java.util.Random;

/**
 * Created by Ryan.T on 11/29/17.
 */

public class Platforms {

    private Texture clouds;
    private Vector2 cloudPos;
    private Rectangle cloudBox;

    public static final int cloud_WIDTH = 347;
    public final static int cloud_HEIGHT = 130;
    private Random rand;
    private Pixmap pixmap;


    public Platforms(float x, float y) {
        cloudBox = new Rectangle(x, y, cloud_WIDTH, cloud_HEIGHT);
        rand = new Random();
        clouds = new Texture("cloud.png");
        cloudPos = new Vector2(x,y);
    }

    public void reposition(float camY) {
        cloudPos.set(rand.nextInt(Gdx.graphics.getWidth()-347), camY + Gdx.graphics.getHeight()/2);
        cloudBox.setPosition(cloudPos.x, cloudPos.y);
    }

    public boolean collide(Rectangle player) {
        return player.overlaps(cloudBox);
    }


    public Texture getClouds() {
        return clouds;
    }

    public Vector2 getCloudPos() {
        return cloudPos;
    }

    public Rectangle getCloudBox() {
        return cloudBox;
    }

    public void KillCloud(){
        cloudBox.setSize(0, 0);
        pixmap = new Pixmap(cloud_WIDTH,cloud_HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor((float)60/255,(float)181/255,0f,0f);
        pixmap.fill();
        clouds = new Texture(pixmap);


    }

}
