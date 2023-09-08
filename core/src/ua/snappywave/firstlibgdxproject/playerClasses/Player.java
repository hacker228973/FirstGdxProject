package ua.snappywave.firstlibgdxproject.playerClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
    private TextureRegion textureRegion;
    private float x;
    private float y;
    private float speed;

    public Player(TextureRegion textureRegion, float x, float y) {
        this.textureRegion = textureRegion;
        this.x = x;
        this.y = y;
        this.speed = 10.0f; // Скорость движения игрока
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void update(float currentX,float currentY) {
        if (Gdx.input.isKeyPressed(Input.Keys.A) && currentY>0) {
            x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)&& currentY<1699) {
            x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)&& currentX<794) {
            y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)&& currentX>0) {
            y -= speed;
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(textureRegion, x, y);
    }

    public void dispose() {
        textureRegion.getTexture().dispose();
    }

    // Другие методы для управления игроком
}
