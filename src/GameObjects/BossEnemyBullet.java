package GameObjects;

import main.Game;
import main.Handler;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullet extends GameObject {
    private final int WIDTH=8;
    private final int HEIGHT=8;

    public BossEnemyBullet(int x, int y, ID id, Handler handler) {
        super(x,y,id);
        this.handler=handler;
        Random r = new Random();
        setVelX(-5+ r.nextInt(10));
        setVelY(3);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (y>=Game.HEIGHT) handler.removeObject(this);

        addTrail(Color.yellow,WIDTH,HEIGHT,0.15f);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x,(int)y,WIDTH,HEIGHT);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,WIDTH,HEIGHT);
    }

}
