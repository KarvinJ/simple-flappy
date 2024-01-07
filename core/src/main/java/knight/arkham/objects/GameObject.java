package knight.arkham.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;


public abstract class GameObject {
    public final Rectangle actualBounds;
    protected TextureRegion actualRegion;
    protected final Sound actionSound;

    protected GameObject(Rectangle bounds, String spritePath, String soundPath) {
        actualBounds = bounds;
        actualRegion = new TextureRegion(new Texture("images/" + spritePath));
        actionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/"+ soundPath));
    }

    public void draw(Batch batch) {

        batch.draw(actualRegion, actualBounds.x, actualBounds.y, actualBounds.width, actualBounds.height);
    }

    public void dispose() {
        actualRegion.getTexture().dispose();
        actionSound.dispose();
    }
}
