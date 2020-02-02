package GameObjects;

import main.Handler;

import java.awt.*;

//#5
public class Trail extends GameObject {
    private float alpha=1;

    private Color color;
    private int height,width;
    private float life;//0.001 - 0.1

    public Trail(int x, int y, ID id,Handler handler,Color color,int width,int height,float life) {
        super(x,y,id);
        this.handler=handler;
        this.color=color;
        this.width=width;
        this.height=height;
        this.life=life;
    }

    @Override
    public void tick() {
        if (alpha > life) {
            alpha-=life-0.001f;
        }else
            handler.removeObject(this);

    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D=(Graphics2D)g;
        graphics2D.setComposite(makeTramsparent(alpha));

        g.setColor(color);
        g.fillRect(x,y,width,height);

        graphics2D.setComposite(makeTramsparent(1));

    }

    private AlphaComposite makeTramsparent(float alpha){
        int type=AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type,alpha);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }


}
