package ru.geekbrains.android.pool;

import ru.geekbrains.android.base.SpritesPool;
import ru.geekbrains.android.sprite.Bullet;


public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}