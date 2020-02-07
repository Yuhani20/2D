package GameObjects;

import main.Game;
import main.Handler;

import java.awt.*;
import java.util.Random;

public class BasicEnemy extends GameObject {
    private final int WIDTH=16;
    private final int HEIGHT=16;

    private Random r=new Random();

    public BasicEnemy(int x, int y, ID id,Handler handler) {
        super(x,y,id);
        this.handler=handler;
        setVelX(2+r.nextInt(6));
        setVelY(3+r.nextInt(4));
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (x<=0||x>= Game.WIDTH-32) velX*=-1;
        if (y<=0||y>=Game.HEIGHT-48) velY*=-1;

        addTrail(Color.red,WIDTH,HEIGHT,0.1f);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,WIDTH,HEIGHT);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,WIDTH,HEIGHT);
    }

}
