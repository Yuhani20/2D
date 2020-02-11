package GameObjects;

import main.Game;
import main.Handler;

import java.awt.*;
import java.util.Random;

public class FasterEnemy extends GameObject {
    private final int WIDTH=10;
    private final int HEIGHT=10;

    public FasterEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        Random r = new Random();
        setVelX(4+ r.nextInt(4));
        setVelY(4+ r.nextInt(4));

    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (x<=0||x>= Game.WIDTH-32) velX*=-1;
        if (y<=0||y>=Game.HEIGHT-48) velY*=-1;

        addTrail(new Color(0x8B5593),WIDTH,HEIGHT,0.07f);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(0x8B5593));
        g.fillRect((int)x,(int)y,WIDTH,HEIGHT);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,WIDTH,HEIGHT);
    }
}
