package ru.geekbrains.android.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.android.math.Rect;
import ru.geekbrains.android.pool.BulletPool;
import ru.geekbrains.android.pool.ExplosionPool;
import ru.geekbrains.android.sprite.Bullet;
import ru.geekbrains.android.sprite.Explosion;

public class Ship extends Sprite {

    protected Vector2 v = new Vector2();

    protected ExplosionPool explosionPool;
    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;
    protected Vector2 bulletV = new Vector2();
    protected float bulletHeight;
    protected int bulletDamage;
    protected int hp;

    protected float reloadInterval;
    protected float reloadTimer;

    protected Rect worldBounds;

    protected Sound shootSound;

    private float damageAnimateInterval = 0.1f;
    private float damageAnimateTimer = damageAnimateInterval;

    public Ship(TextureRegion region, int rows, int cols, int frames, Sound shootSound) {
        super(region, rows, cols, frames);
        this.shootSound = shootSound;
    }

    public Ship() {

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        damageAnimateTimer += delta;
        if (damageAnimateTimer >= damageAnimateInterval) {
            frame = 0;
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
    }

    public void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion ,pos, bulletV, bulletHeight, worldBounds, bulletDamage);
        shootSound.play();
    }

    public void boom() {
        Explosion explosion = explosionPool.obtain();
        explosion.set(getHeight(), pos);
    }

    public void damage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            setDestroyed(true);
            boom();
        }
        damageAnimateTimer = 0f;
        frame = 1;
    }

    public int getHp() {
        return hp;
    }
}
