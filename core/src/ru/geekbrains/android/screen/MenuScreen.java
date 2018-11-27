package ru.geekbrains.android.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.android.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private Texture img;

    private Vector2 pos;
    private Vector2 v;

    private Vector2 touch;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0,0);
        v = new Vector2(0.5f, 0.3f);
        touch = new Vector2();
//        v = new Vector2(100f, 100f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0.3f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        pos.add(v);
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touch X = " + touch.x + " touch Y = " + touch.y);
        return false;
    }
}

