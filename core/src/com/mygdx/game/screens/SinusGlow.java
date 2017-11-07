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
 * Created by rinat on 16.04.2016.
 */
public class SinusGlow implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Stage stage;

    private ShaderProgram shader;

    private Texture quadTexture;

    private float resolution[];

    private float time = 0.0f;

    @Override
    public void show() {

        batch    = Env.game.getBatch();
        camera   = Env.game.getCamera();
        viewport = Env.game.getViewport();

        stage = new Stage(viewport, batch);

        ShaderProgram.pedantic = false;
        shader = new ShaderProgram(Gdx.files.internal("shaders/glowingline.vert"),
                Gdx.files.internal("shaders/glowingline.frag"));

        batch.setShader(shader);

        if (!shader.isCompiled()) {
            Gdx.app.error("Shader", shader.getLog());
        }

        quadTexture = new Texture("textures/quad.png");

        resolution = new float[2];

        Gdx.input.setInputProcessor(stage);

        //Gdx.app.log(Env.game.TAG, "Test Succesful");
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        time += delta;

        batch.begin();
        shader.setUniform2fv("resolution", resolution , 0, 2);
        shader.setUniformf("time", time);
        batch.draw(quadTexture, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        batch.end();

        // Update stage
        stage.act(delta);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);

        resolution[0] = width;
        resolution[1] = height;
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
        shader.dispose();
    }

}