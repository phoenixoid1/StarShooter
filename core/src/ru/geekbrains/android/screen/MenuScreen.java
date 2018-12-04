package ru.geekbrains.android.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.android.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    private Texture img;

    private Vector2 currPos;
    private Vector2 newPos;
    private Vector2 distance;
    private Vector2 step;
    private float speed;

    private Vector2 touch;

    private float imageSizeInPercentOfScreen = 30;
    private float imageSize;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        currPos = new Vector2(0, 0);
        newPos = new Vector2(0, 0);
        speed = 0.1f;
        touch = new Vector2();
        distance = new Vector2();
        step = new Vector2();
        imageSize = super.getMyHeight() * imageSizeInPercentOfScreen / 100;
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
        batch.draw(img, currPos.x, currPos.y, imageSize, imageSize);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        System.out.println(" Override touchDown touch.x = " + touch.x + " touch.y = " + touch.y);
        newPos.x = touch.x - imageSize /2;
        newPos.y = touch.y - imageSize /2;
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);
        float step = 0.1f;
        switch (keycode) {
            case 19:
                currPos.y += step;
                newPos.y += step;
                break;
            case 20:
                currPos.y -= step;
                newPos.y -= step;
                break;
            case 21:
                currPos.x -= step;
                newPos.x -= step;
                break;
            case 22:
                currPos.x += step;
                newPos.x += step;
                break;
            default:
                break;
        }
        return false;
    }

}
