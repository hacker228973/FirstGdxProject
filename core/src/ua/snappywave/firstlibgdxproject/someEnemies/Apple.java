package ua.snappywave.firstlibgdxproject.someEnemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import ua.snappywave.firstlibgdxproject.playerClasses.Player;

public class Apple extends Enemy{

    private TextureRegion textureRegion;
    private float x;
    private float y;
    boolean visible=true;
    private static int enemyFrameSizeX=54;
    private static int enemyFrameSizeY=56;

    public Apple(TextureRegion texture, float x, float y) {
        super(texture);
        this.textureRegion = texture;
        this.x=x;
        this.y=y;
    }

    public void draw(SpriteBatch batch) {
        if (visible) {
            batch.draw(textureRegion, x, y);
        }
    }

    public void dispose() {
        textureRegion.getTexture().dispose();
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    public static int getEnemyFrameSizeX() {
        return enemyFrameSizeX;
    }

    public static int getEnemyFrameSizeY() {
        return enemyFrameSizeY;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
