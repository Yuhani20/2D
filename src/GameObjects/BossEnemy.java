package GameObjects;

import main.Game;
import main.Handler;

import java.awt.*;
import java.util.Random;

public class BossEnemy extends GameObject {
    private final int WIDTH=54;
    private final int HEIGHT=54;

    private int timer=30;
    private int timer2=100;

    Random r=new Random();

    public BossEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;

        setVelX(0);
        setVelY(2);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (timer<=0) {
            velY=0;
            timer2--;
        } else timer--;

        if (timer2<=0){
            if (velX==0) velX=-2;
            int spawn=r.nextInt(8);
            if (spawn==0)
            handler.addObject(new BossEnemyBullet((int)x+20,(int)y+20,ID.BossEnemyBullet,handler));
        }

        if (x<=0||x>= Game.WIDTH-32) velX*=-1;
        if (y<=0||y>=Game.HEIGHT-48) velY*=-1;

        addTrail(new Color(0xAE9842),WIDTH,HEIGHT,0.1f);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(0xAE9842));
        g.fillRect((int)x,(int)y,WIDTH,HEIGHT);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,WIDTH,HEIGHT);
    }
}
