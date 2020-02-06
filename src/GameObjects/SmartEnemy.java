package GameObjects;

import main.Game;
import main.Handler;

import java.awt.*;
import java.util.Random;

public class SmartEnemy extends GameObject {
    private final int WIDTH=16;
    private final int HEIGHT=16;

    private GameObject player;

    private Random r=new Random();

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x,y,id);
        this.handler=handler;

        for (int i = 0; i < handler.getSize(); i++) {
            if (handler.getObject(i).getId()==ID.Player){
                player=handler.getObject(i);
            }

        }

    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        float diffX = x-player.getX()-16;
        float diffY = y-player.getY()-16;
        float distance=(float)Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));

        velX=(int)((-1/distance)*diffX);
        velY=(int)((-1/distance)*diffY);

        if (x<=0||x>= Game.WIDTH-32) velX*=-1;
        if (y<=0||y>=Game.HEIGHT-48) velY*=-1;

        addTrail(Color.red,16,16,0.1f);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect(x,y,WIDTH,HEIGHT);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }

}
