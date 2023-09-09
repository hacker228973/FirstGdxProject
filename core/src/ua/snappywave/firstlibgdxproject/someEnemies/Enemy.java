package ua.snappywave.firstlibgdxproject.someEnemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

abstract public class Enemy {
    private TextureRegion textureRegion;
    private float x;
    private float y;
    private static int enemyFrameSizeX;
    private static int enemyFrameSizeY;

    public Enemy(TextureRegion texture) {
        this.textureRegion = texture;
        this.x = x;
        this.y = y;
    }
    public void draw(SpriteBatch batch) {
        batch.draw(textureRegion, x, y);
    }

    public void dispose() {
        textureRegion.getTexture().dispose();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
