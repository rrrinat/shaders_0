package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.WaveScreen;

public class MyShaders extends Game {

	public static final String TAG = "MyShaderApplication";

	public static final float SCENE_WIDTH = 800.0f;
	public static final float SCENE_HEIGHT = 480.0f;

	private SpriteBatch batch;
	private OrthographicCamera camera;

	private Viewport viewport;

	@Override
	public void create () {

		Env.init(this);

		batch = new SpriteBatch();

		camera   = new OrthographicCamera();
		viewport = new FitViewport(SCENE_WIDTH, SCENE_HEIGHT, camera);


		//setScreen(new GameScreen());
		setScreen(new WaveScreen());
	}

	@Override
	public void dispose() {

		super.dispose();
	}

	@Override
	public void render () {

		super.render();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public Viewport getViewport() {
		return viewport;
	}
}