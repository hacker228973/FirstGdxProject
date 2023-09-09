package ua.snappywave.firstlibgdxproject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import ua.snappywave.firstlibgdxproject.playerClasses.Player;
import ua.snappywave.firstlibgdxproject.someEnemies.Apple;
import ua.snappywave.firstlibgdxproject.someEnemies.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class LibGDX_1 extends ApplicationAdapter {
    SpriteBatch batch;
    Texture backgroundTexture;
    Texture playerTextures;
    Texture appleTextures;
    TextureRegion appleTexture;
    TextureRegion playerTexture;

    Player player;
    OrthographicCamera camera;

    ArrayList<Apple> apples;
    BitmapFont font;
    Random random;

    private int currentFrameIndex = 1;
    private float stateTime = 0.0f;
    private float frameDuration = 0.1f;


    ArrayList<TextureRegion> playerTextureFrames;


    @Override
    public void create() {
        random = new Random();

        batch = new SpriteBatch();


        playerTextureFrames = new ArrayList<>();
        for (int i = 1; i < 23; i++) {
            playerTextureFrames.add(new TextureRegion(new Texture("playerTextures/" + i + ".png")));

        }

        playerTexture = new TextureRegion(new Texture("playerTextures/1.png"));
        backgroundTexture = new Texture("backGround.png");


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);
        camera.update();

        font = new BitmapFont();
        font.getData().setScale(2);


        player = new Player(playerTexture, Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
    }

    @Override
    public void render() {


        if (!player.isAnimationPause()) {
            stateTime += Gdx.graphics.getDeltaTime();

        }
        player.setAnimationPause(false);
        // Вычисляем текущий кадр текстуры на основе stateTime и frameDuration
        currentFrameIndex = (int) (stateTime / frameDuration) % playerTextureFrames.size();

        // Получаем текущую текстуру
        TextureRegion currentTexture = playerTextureFrames.get(currentFrameIndex);

        // Остальной код отрисовки остается без изменений

        batch.begin();

        batch.draw(backgroundTexture, 0, 0, 1920, 1080);
        player.update(player.getY(), player.getX());


        player.setTextureFrame(currentTexture);
        player.draw(batch);
        font.draw(batch, "Score: " + player.getAppleCounter(), Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);


        batch.end();


    }

    @Override
    public void dispose() {
        player.dispose();
        font.dispose();
        backgroundTexture.dispose();
        batch.dispose();
    }
}
