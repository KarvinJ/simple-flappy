package knight.nameless;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import knight.nameless.screens.GameScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Android extends Game {

    public static Android INSTANCE;
    public OrthographicCamera camera;
    public FitViewport viewport;
    public final int screenWidth = 480;
    public final int screenHeight = 640;
    public boolean isGameOver;

    public Android() {

        INSTANCE = this;
    }

    @Override
    public void create() {

        camera = new OrthographicCamera();
        camera.position.set(screenWidth / 2f, screenHeight / 2f, 0);

        //a FitViewPort is better when the resolution or your game is lower than the device.
        viewport = new FitViewport(screenWidth , screenHeight, camera);

        setScreen(new GameScreen());
    }
}
