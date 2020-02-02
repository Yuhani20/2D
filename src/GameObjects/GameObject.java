package GameObjects;

import main.Handler;

import java.awt.*;

public abstract class GameObject {
    protected Handler handler;

    protected int x,y;
    protected ID id;
    protected int velX,velY;

    public GameObject(int x,int y,ID id) {
         setId(id);
         setX(x);
         setY(y);
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void setX(int x) { this.x=x; }
    public void setY(int y) { this.y=y; }
    public int getX() { return x; }
    public int getY() {
        return y;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public ID getId() {
        return id;
    }
    public void setVelX(int velX) {
        this.velX=velX;
    }
    public void setVelY(int velY) {
        this.velY=velY;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }

    public  void addTrail(Color color,int width,int height,float life){
        handler.addObject(new Trail(x,y,ID.Trail,handler,color,width,height,life));
    }

}
