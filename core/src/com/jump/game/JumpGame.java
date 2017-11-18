package com.jump.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;
import java.util.Map;

public class JumpGame extends ApplicationAdapter {
	private Viewport viewport;
	private Camera camera;

	private BitmapFont font;
    private SpriteBatch batch;
	private String message = "touch something";
	private int w,h;
	class TouchInfo{
	    public float touchX = 0;
	    public float touchY = 0;
	    public boolean touched = false;
    }
    private Map<Integer,TouchInfo> touches = new HashMap<Integer,TouchInfo>();

	@Override
	public void create () {
		System.out.println(Gdx.graphics.getWidth());
		System.out.println(Gdx.graphics.getHeight());
		camera = new PerspectiveCamera();
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
		float screenHeight = Gdx.graphics.getHeight();
		float screenWidth = Gdx.graphics.getWidth();

		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/arial-15.fnt"),false);
		font.setColor(Color.RED);
		Gdx.input.setInputProcessor(this);
		for(int i=0;i<5;i++){
		    touches.put(i,new TouchInfo());
        }
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		message = "";
		for(int i=0;i<5;i++){
		    if(touches.get(i).touched){
		        message+= "Finger:" + Integer.toString(i) + "touch at:" +
                        Float.toString(touches.get(i).touchX) + "," +
                        Float.toString(touches.get(i).touchY) + "\n";
            }
        }
        TextBounds tb = font.getBounds(message);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
