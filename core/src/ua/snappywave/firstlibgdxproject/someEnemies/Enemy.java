package ua.snappywave.firstlibgdxproject.someEnemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

abstract public class Enemy {
    private TextureRegion textureRegion;
    private float x;
    private float y;

    public Enemy(TextureRegion texture, float x, float y) {
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
}
