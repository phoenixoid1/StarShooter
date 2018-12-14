package ru.geekbrains.android.pool;


import ru.geekbrains.android.base.SpritesPool;
import ru.geekbrains.android.math.Rect;
import ru.geekbrains.android.sprite.Enemy;
import ru.geekbrains.android.sprite.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private MainShip mainShip;
    private Rect worldBounds;

    public EnemyPool(BulletPool bulletPool, MainShip mainShip, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.mainShip = mainShip;
        this.worldBounds = worldBounds;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, mainShip, worldBounds);
    }
}
