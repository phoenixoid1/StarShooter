package ru.geekbrains.android.pool;

import com.badlogic.gdx.audio.Sound;

import ru.geekbrains.android.base.SpritesPool;
import ru.geekbrains.android.math.Rect;
import ru.geekbrains.android.sprite.Enemy;
import ru.geekbrains.android.sprite.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private MainShip mainShip;
    private Rect worldBounds;
    private Sound shootSound;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, MainShip mainShip, Rect worldBounds, Sound shootSound) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.mainShip = mainShip;
        this.worldBounds = worldBounds;
        this.shootSound = shootSound;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, explosionPool, mainShip, worldBounds, shootSound);
    }
}