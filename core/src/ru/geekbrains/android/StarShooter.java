package ru.geekbrains.android;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class StarShooter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		Vector2 v1 = new Vector2(1f, 4f);
		Vector2 v2 = new Vector2(0, -1f);
		v1.add(v2);
		System.out.println("v1.x = " + v1.x + " v1.y = " + v1.y);
		v1.set(1f, 2f);
		v2.set(4f, 4f);
		Vector2 v3 = v2.cpy().sub(v1);
		System.out.println("v2.x = " + v2.x + " v2.y = " + v2.y);
		System.out.println("v3.x = " + v3.x + " v3.y = " + v3.y);
		System.out.println("v3.len = " + v3.len());
		v3.nor();
		System.out.println("v3.len = " + v3.len());
		System.out.println("v3.x = " + v3.x + " v3.y = " + v3.y);
		v2.scl(0.9f);
		System.out.println("v2.x = " + v2.x + " v2.y = " + v2.y);

		v1.set(1,1);
		v2.set(-1,1);
		System.out.println(v1.dot(v2));
		System.out.println(Math.acos(v1.dot(v2)));

		v1.set(3,-2);
		v2.set(-1,6);
		System.out.println(v1.dot(v2));
		System.out.println(Math.acos(v1.dot(v2)));

		v1.set(3,-2).nor();
		v2.set(-1,6).nor();
		System.out.println(v1.dot(v2));
		System.out.println(Math.acos(v1.dot(v2)));


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0f, 0.25f, 0.33f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
