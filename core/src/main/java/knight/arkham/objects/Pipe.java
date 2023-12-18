package knight.arkham.objects;

import com.badlogic.gdx.math.Rectangle;

public class Pipe extends GameObject {

    public Pipe(Rectangle bounds, boolean isRotated) {
        super(bounds, isRotated ? "pipe-green-180.png" :"pipe-green.png", "die.wav");
    }

    public void update() {
        actualBounds.x -= 1;

//        body.setLinearVelocity(-4 , 0);
    }
}
