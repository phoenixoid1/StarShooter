package ru.geekbrains.android.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.android.base.ScaledButton;
import ru.geekbrains.android.math.Rect;
import ru.geekbrains.android.screen.GameScreen;


public class PlayAgainButton extends ScaledButton {

    Game game;
    public PlayAgainButton(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        setHeightProportion(0.05f);
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom() + 0.05f);
    }

    @Override
    public void actionPerformed() {
        game.setScreen(new GameScreen(game));
    }
}
