package ru.geekbrains.android.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.android.base.ScaledButton;
import ru.geekbrains.android.math.Rect;
import ru.geekbrains.android.screen.GameScreen;


public class PlayAgainButton extends ScaledButton {

    private GameScreen gameScreen;

    public PlayAgainButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
        setHeightProportion(0.05f);
        setTop(-0.012f);
    }

    @Override
    public void actionPerformed() {
        gameScreen.startNewGame();
    }
}
