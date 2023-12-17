package knight.arkham.objects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import knight.arkham.helpers.AssetsHelper;

public abstract class GameObject {
    public final Rectangle actualBounds;
    protected TextureRegion actualRegion;
    protected final Sound actionSound;

    protected GameObject(Rectangle bounds, String spritePath, String soundPath) {
        actualBounds = bounds;
        actualRegion = new TextureRegion(new Texture("images/" + spritePath));
        actionSound = AssetsHelper.loadSound(soundPath);
    }

    public void draw(Batch batch) {

        batch.draw(actualRegion, actualBounds.x, actualBounds.y, actualBounds.width, actualBounds.height);
    }

    protected Animation<TextureRegion> makeAnimationByRegion(TextureRegion region, int regionWidth, int regionHeight) {

        Array<TextureRegion> animationFrames = new Array<>();

        for (int i = 0; i < 3; i++)
            animationFrames.add(new TextureRegion(region, i * regionWidth, 0, regionWidth, regionHeight));

        return new Animation<>(0.1f, animationFrames);
    }

    public void hasCollideWithThePlayer(){
        actionSound.play();
    }

    public void dispose() {
        actualRegion.getTexture().dispose();
        actionSound.dispose();
    }
}
