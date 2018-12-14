package ru.geekbrains.android.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import ru.geekbrains.android.base.ScaledButton;
import ru.geekbrains.android.math.Rect;


public class ExitButton extends ScaledButton {

    public ExitButton(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
        setHeightProportion(0.15f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom() + 0.01f);
        setRight(worldBounds.getRight() - 0.01f);
    }

    @Override
    public void actionPerformed() {
        Gdx.app.exit();
    }
}
