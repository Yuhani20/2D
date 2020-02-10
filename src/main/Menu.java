package main;

import GameObjects.BasicEnemy;
import GameObjects.ID;
import GameObjects.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Handler handler;
    private Random r=new Random();

    public Menu(Handler handler){
        this.handler=handler;
    }

    public void mousePressed(MouseEvent e){
        int mX=e.getX();
        int mY=e.getY();

        if(Game.state==STATE.Menu) {
            if (mouseOver(mX, mY)) {
                Game.state = STATE.Game;
                handler.addObject(new Player(r.nextInt(Game.WIDTH2), r.nextInt(Game.HEIGHT2), ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH2), r.nextInt(Game.HEIGHT2), ID.BasicEnemy, handler));
            }

            if (mouseOver2(mX, mY)) {
                Game.state = STATE.About;
            }

            if (mouseOver3(mX, mY)) {
                System.exit(1);
            }
        }

        else if (Game.state==STATE.About){
            if (mouseOver4(mX,mY)){
                Game.state=STATE.Menu;
            }
        }

    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mX, int mY){
        return mX > 10 && mX < 10 + 100 && mY > 50 && mY < 50 + 20;
    }

    private boolean mouseOver2(int mX, int mY){
        return mX > 15 && mX < 15 + 100 && mY > 100 && mY < 100 + 20;
    }

    private boolean mouseOver3(int mX, int mY){
        return mX > 20 && mX < 20 + 100 && mY > 150 && mY < 150 + 20;
    }

    private boolean mouseOver4(int mX, int mY){
        return mX > 115 && mX < 115 + 100 && mY > 100 && mY < 100 + 20;
    }

    public void tick(){

    }

    public void render(Graphics g){
        if (Game.state==STATE.Menu) {
            Font font = new Font("font name", Font.ITALIC, 15);
            g.setFont(font);

            g.setColor(Color.white);
            g.drawRect(10, 50, 100, 20);
            g.drawString("START", 40, 64);

            g.setColor(Color.lightGray);
            g.drawRect(15, 100, 100, 20);
            g.drawString("ABOUT", 45, 114);

            g.setColor(Color.DARK_GRAY);
            g.drawRect(20, 150, 100, 20);
            g.drawString("OUT", 60, 164);
        }

        else if (Game.state==STATE.About){
            Font font2=new Font("font name", Font.PLAIN,20);
            g.setFont(font2);
            g.setColor(Color.lightGray);
            g.drawString("2020 春",25,118);

            Font font3=new Font("font name", Font.ITALIC,15);
            g.setFont(font3);
            g.setColor(Color.lightGray);
            g.drawRect(115, 100,100,20);
            g.drawString("《——",135,114);
        }

    }

}
