package GameObjects;

import main.Game;
import main.HUD;
import main.Handler;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id,Handler handler) {
        super(x,y,id);
        this.handler=handler;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        x=Game.clamp(x,0,Game.WIDTH-48);
        y=Game.clamp(y,0,Game.HEIGHT-70);

        addTrail(Color.lightGray,32,32,0.25f);

        collision();
    }

    private void collision() {
        for (int i=0;i<handler.getSize();i++){

            GameObject tempObject=handler.getObject(i);

            if (tempObject.getId()==ID.BasicEnemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.setHealth(HUD.getHealth()-3);
                }
            }

            if (tempObject.getId()==ID.FasterEnemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.setHealth(HUD.getHealth()-2);
                }
            }

            if (tempObject.getId()==ID.SmartEnemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.setHealth(HUD.getHealth()-2);
                }
            }

            if (tempObject.getId()==ID.BossEnemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.setHealth(HUD.getHealth()-4);
                }
            }

            if (tempObject.getId()==ID.BossEnemyBullet){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.setHealth(HUD.getHealth()-1);
                }
            }


        }

    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D=(Graphics2D)g;

        g.setColor(Color.lightGray);
        g.fillRect((int)x,(int)y,32,32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }
}
