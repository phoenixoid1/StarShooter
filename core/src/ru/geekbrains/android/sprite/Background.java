package ru.geekbrains.android.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.android.base.Sprite;
import ru.geekbrains.android.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        System.out.println("resize background");
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}