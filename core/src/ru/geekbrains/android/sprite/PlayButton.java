package ru.geekbrains.android.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.android.base.Sprite;
import ru.geekbrains.android.math.Rect;

public class PlayButton extends Sprite {

    private Rect worldBounds;

    private float proportion = 0.15f;
    private float offsetX = -0.35f;
    private float offsetY = -0.35f;
    private float aspect;

    public PlayButton(TextureAtlas atlas) {
        super(atlas.findRegion("btPlay"));
        setHeightProportion(proportion);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        aspect = worldBounds.getWidth() / (float) worldBounds.getHeight();
        pos.set(offsetX *aspect, offsetY);
    }
    public void makeSmaller(){
        setHeightProportion(proportion*0.9f);
    }

    public void makeNormal(){
        setHeightProportion(proportion);
    }
}
