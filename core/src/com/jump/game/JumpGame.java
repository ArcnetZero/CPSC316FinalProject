package com.jump.game;

import com.jump.game.play.gameplay;
import com.jump.game.play.GameStateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//We use TextureAtlas to group animated images together;


//what ApplicationAdaptor does is it includes a bunch of methods that can be called automatically at different points in your game.
//i.g create()/render()/dispose() etc
public class JumpGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private GameStateManager gsm;


	@Override
	public void create () {
		Gdx.graphics.setContinuousRendering(true);
		System.out.println(Gdx.graphics.getHeight());
		System.out.println(Gdx.graphics.getWidth());
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		gsm.push(new gameplay(gsm));

	}

	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}





}
