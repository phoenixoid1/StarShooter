package ru.geekbrains.android.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.android.base.Base2DScreen;

public class MoveImageScreen extends Base2DScreen {
    private Texture img;
    private int imgHalfOfWidtht;
    private int imgHalfOfHeight;

    private Vector2 currPos;
    private Vector2 newPos;
    private Vector2 distance;
    private Vector2 step;
    private float speed;

    private Vector2 touch;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        imgHalfOfWidtht = img.getWidth() / 2;
        imgHalfOfHeight = img.getHeight() / 2;
        currPos = new Vector2(0, 0);
        newPos = new Vector2(0, 0);
        speed = 3.1f;
        touch = new Vector2();
        distance = new Vector2();
        step = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0.3f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(!currPos.equals(newPos)){
            distance.set(newPos).sub(currPos);
            step.set(distance).nor().scl(speed);
            if(step.len() > distance.len()){
                currPos.x = newPos.x;
                currPos.y = newPos.y;
            }else {
                currPos.add(step);
            }
        }
        batch.draw(img, currPos.x, currPos.y);
        batch.end();
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
        newPos.x = touch.x - imgHalfOfWidtht;
        newPos.y = touch.y - imgHalfOfHeight;
        System.out.println("touch X = " + touch.x + " touch Y = " + touch.y);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);
        int step = 10;
        switch (keycode) {
            case 19:
                currPos.y += step;
                break;
            case 20:
                currPos.y -= step;
                break;
            case 21:
                currPos.x -= step;
                break;
            case 22:
                currPos.x += step;
                break;
            default:
                break;
        }
        return false;
    }

    public void doSomething(String s){
        System.out.println(s);
    }
}
