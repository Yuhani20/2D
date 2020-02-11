package GameObjects;

import main.Game;
import main.Handler;

import java.awt.*;
import java.util.Random;

public class Adornment extends GameObject {
    private final int WIDTH=10;
    private final int HEIGHT=10;

    public Adornment(int x, int y, ID id, Handler handler) {
        super(x,y,id);
        this.handler=handler;
        Random r = new Random();
        setVelX(-2+ r.nextInt(4));
        setVelY(-2);
        if (velX==0) setVelX(1);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (x<=0||x>= Game.WIDTH-32) velX*=-1;
        if (y<=0||y>=Game.HEIGHT-48) velY*=-1;

        addTrail(new Color(0xC12B44),WIDTH,HEIGHT,0.15f);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(0xFF1D39));
        g.fillOval((int)x,(int)y,WIDTH,HEIGHT);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,WIDTH,HEIGHT);
    }

}

