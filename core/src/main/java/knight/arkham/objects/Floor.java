package knight.arkham.objects;

import com.badlogic.gdx.math.Rectangle;

public class Floor extends GameObject {

    public Floor(Rectangle bounds) {
        super(bounds, "base.png", "die.wav");
    }

    public void update(float deltaTime) {

        actualBounds.x -= 150 * deltaTime;

        if (actualBounds.x <= -478)
            actualBounds.setPosition(480, 0);
    }
}
