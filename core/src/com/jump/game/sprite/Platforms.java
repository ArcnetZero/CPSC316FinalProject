package com.jump.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 * Created by Ryan.T on 11/29/17.
 */

public class Platforms {

    private Texture Clouds;
    private Vector2 cloudPos;
    private Random rand;
    private int xFlunc = 700;

    public Platforms(float x) {
        rand = new Random();
        Clouds = new Texture("cloud.png");
        cloudPos = new Vector2(x, rand.nextInt(xFlunc));


    }




}
