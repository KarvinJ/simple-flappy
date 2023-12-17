package knight.arkham.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Floor extends GameObject {

    public Floor(Rectangle bounds) {
        super(bounds, "base.png", "die.wav");
    }

    public void update() {

//        body.setLinearVelocity(-4 , 0);

//        The parallax effect implemented with two floors
        if (actualBounds.x < -230) {

            Vector2 outScreenPosition = new Vector2(720, 40).scl(1/32f);
//            body.setTransform(outScreenPosition, 0);
        }
    }
}
