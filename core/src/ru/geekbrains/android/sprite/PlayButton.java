package ru.geekbrains.android.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.android.base.ScaledButton;
import ru.geekbrains.android.math.Rect;
import ru.geekbrains.android.screen.GameScreen;


public class PlayButton extends ScaledButton {

    private Game game;


    public PlayButton(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        setHeightProportion(0.15f);
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom() + 0.01f);
        setLeft(worldBounds.getLeft() + 0.01f);
    }

    @Override
    protected void actionPerformed() {
        game.setScreen(new GameScreen(game));
    }
}
