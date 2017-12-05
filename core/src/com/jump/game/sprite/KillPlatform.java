package com.jump.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 * Created by Brenden Carney on 12/5/2017.
 */

public class KillPlatform {
    private Texture clouds;
    private Vector2 cloudPos;
    private Rectangle cloudBox;
    private Pixmap pixmap;


    public void killPlatform() {
        pixmap = new Pixmap(Gdx.graphics.getWidth(),20, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();

        cloudBox = new Rectangle(0, 0, Gdx.graphics.getWidth(),20);
        clouds = new Texture(pixmap);
        cloudPos = new Vector2(0,0);
    }

    public void repositionKillBox(float camY){
        cloudPos.set(0, camY);
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
}
