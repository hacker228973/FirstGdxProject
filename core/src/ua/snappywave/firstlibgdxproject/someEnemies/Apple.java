package ua.snappywave.firstlibgdxproject.someEnemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Apple extends Enemy{

    private TextureRegion textureRegion;
    private float x;
    private float y;

    public Apple(TextureRegion texture, float x, float y) {
        super(texture, x, y);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(textureRegion, x, y);
    }

    public void dispose() {
        textureRegion.getTexture().dispose();
    }
}
