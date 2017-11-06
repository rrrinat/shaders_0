package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Env;

/**
 * Created by rinat on 15.04.2016.
 */
public class GameScreen implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Stage stage;

    private ShaderProgram shader;

    private Texture quadTexture;

    @Override
    public void show() {

        batch    = Env.game.getBatch();
        camera   = Env.game.getCamera();
        viewport = Env.game.getViewport();

        stage = new Stage(viewport, batch);

        ShaderProgram.pedantic = false;
        shader = new ShaderProgram(Gdx.files.internal("shaders/redsquare.vert"),
                Gdx.files.internal("shaders/redsquare.frag"));

        batch.setShader(shader);

        if (!shader.isCompiled()) {
            Gdx.app.error("Shader", shader.getLog());
        }

        quadTexture = new Texture("textures/quad.png");

        Gdx.input.setInputProcessor(stage);

        //Gdx.app.log(Env.game.TAG, "Test Succesful");
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(quadTexture, 200, 200);
        batch.end();

        // Update stage
        stage.act(delta);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        quadTexture.dispose();
        shader.dispose();
    }

}
