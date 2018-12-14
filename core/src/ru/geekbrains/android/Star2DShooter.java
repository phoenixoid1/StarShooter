package ru.geekbrains.android;

import com.badlogic.gdx.Game;

import ru.geekbrains.android.screen.MenuScreen;


public class Star2DShooter extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
