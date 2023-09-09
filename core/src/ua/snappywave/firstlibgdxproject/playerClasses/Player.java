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
    private float scale;
    private float playerFrameSizeX; // Размеры персонажа
    private float playerFrameSizeY;
    private float maxCoordinateX;
    private float maxCoordinateY;
    private float startCoordinate;
    boolean animationPause;




    private int appleCounter;

    // Добавьте переменную для хранения направления персонажа
    private int directionX = 1; // 1 для правого направления, -1 для левого

    public Player(TextureRegion textureRegion, float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 4.0f;
        this.scale = 1f;
        this.appleCounter = appleCounter;
        directionX = 1;
        playerFrameSizeX = textureRegion.getRegionWidth()*scale;
        playerFrameSizeY = textureRegion.getRegionHeight()*scale;
        maxCoordinateX = 1080 - playerFrameSizeY;
        maxCoordinateY = 1920 - playerFrameSizeX;
        startCoordinate = 0;
        animationPause=false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getAppleCounter() {
        return appleCounter;
    }


    public void setAnimationPause(boolean animationPause) {
        this.animationPause = animationPause;
    }

    public boolean isAnimationPause() {
        return animationPause;
    }

    public void update(float currentX, float currentY) {
        if (Gdx.input.isKeyPressed(Input.Keys.A) && currentY > startCoordinate) {
            x -= speed;
            directionX = 1; // Изменяем направление на лево
            setAnimationPause(true);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && currentY < maxCoordinateY) {
            x += speed;
            directionX = -1; // Изменяем направление на право
            setAnimationPause(true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)&& currentX<maxCoordinateX) {
            y += speed;
            setAnimationPause(true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)&& currentX>startCoordinate) {
            y -= speed;
            setAnimationPause(true);
        }


    }

    public void draw(SpriteBatch batch) {
        float width = playerFrameSizeX;
        float height = playerFrameSizeY;

        // Отразите текстуру по горизонтали, если персонаж движется влево
        if (directionX == 1) {
            batch.draw(textureRegion, x + width, y, -width, height);
        } else {
            batch.draw(textureRegion, x, y, width, height);
        }
    }

    public void dispose() {
        textureRegion.getTexture().dispose();
    }

    public void setTextureFrame(TextureRegion texture){
        this.textureRegion=texture;
    }


}
