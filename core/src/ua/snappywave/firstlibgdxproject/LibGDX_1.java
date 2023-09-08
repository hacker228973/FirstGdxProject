package ua.snappywave.firstlibgdxproject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import ua.snappywave.firstlibgdxproject.playerClasses.Player;
import ua.snappywave.firstlibgdxproject.someEnemies.Apple;
import ua.snappywave.firstlibgdxproject.someEnemies.Enemy;

public class LibGDX_1 extends ApplicationAdapter {
    SpriteBatch batch;
    Texture backgroundTexture;
    Texture playerTextures;
    Texture appleTextures;
    TextureRegion appleTexture;
    TextureRegion playerTexture;

    Player player;
    Enemy apple;
	OrthographicCamera camera;

    @Override
    public void create() {
		batch = new SpriteBatch();

        appleTextures = new Texture("apple.png");
        appleTexture = new TextureRegion(appleTextures);
		playerTextures = new Texture("player.png");
		playerTexture = new TextureRegion(playerTextures);
		backgroundTexture = new Texture("backGround.png");


		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);
		camera.update();



        apple =  new Apple(appleTexture,Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        player = new Player(playerTexture, Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
    }

    @Override
    public void render() {


		player.update(player.getY(),player.getX());


        batch.begin();
        batch.draw(backgroundTexture, 0,0, 1920,1080);
		player.draw(batch);
        apple.draw(batch);
        batch.end();


    }

    @Override
    public void dispose() {
        player.dispose();
        apple.dispose();

        backgroundTexture.dispose();
        batch.dispose();
    }
}
