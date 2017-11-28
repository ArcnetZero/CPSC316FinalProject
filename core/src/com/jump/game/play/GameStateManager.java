package com.jump.game.play;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Ryan.T on 11/21/17.
 */


public class GameStateManager {
    Stack<state> States;

    public GameStateManager() {
        States = new Stack<state>();
    }

    public void push(state state) {
        States.push(state);

    }

    public void pop(state state) {
        States.pop();

    }

    public void set(state state) {
        States.pop();
        States.push(state);
    }

    public void update(float dt) {
        States.peek().update(dt);

    }

    public void render(SpriteBatch sb) {
        States.peek().render(sb);
    }

}


