package knight.arkham.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import knight.arkham.Space;

public class Player extends GameObject {
    public static int score;
    private boolean isGameOver;
    private float animationTimer;
    private final Animation<TextureRegion> flappingAnimation;

    public Player(Vector2 position) {
        super(
            new Rectangle(position.x, position.y, 50, 40),
            "yellowbird-midflap.png", "wing.wav"
        );

        TextureRegion region = new TextureAtlas("images/birds.atlas").findRegion("yellow-bird");

        int regionWidth = region.getRegionWidth() / 3;

        flappingAnimation = makeAnimationByRegion(region, regionWidth, region.getRegionHeight());
    }

    public void update(float deltaTime) {

        animationTimer += deltaTime;

        actualRegion = flappingAnimation.getKeyFrame(animationTimer, true);

        if (!isGameOver && Gdx.input.justTouched()) {

            actionSound.play();
            applyLinealImpulse(new Vector2(0, 20));
        }

        if (actualBounds.y > 700)
            Space.INSTANCE.isGameOver = true;
    }

    private void applyLinealImpulse(Vector2 impulseDirection) {
//        body.applyLinearImpulse(impulseDirection, body.getWorldCenter(), true);
    }

    public void hasCollide(){
        isGameOver = true;
    }
}
