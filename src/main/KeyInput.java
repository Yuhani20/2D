package main;

import GameObjects.GameObject;
import GameObjects.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    private boolean[]keyDown=new boolean[4];

    public KeyInput(Handler handler){
        this.handler=handler;
    }

    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();

        for(int i=0;i<handler.getSize();i++){
            GameObject tempObject=handler.getObject(i);

            if(tempObject.getId()== ID.Player){
                //key events for Player

                if(key==KeyEvent.VK_W) {tempObject.setVelY(-4); keyDown[0]=true;}
                if(key==KeyEvent.VK_S) {tempObject.setVelY(4);  keyDown[1]=true;}
                if(key==KeyEvent.VK_A) {tempObject.setVelX(-4); keyDown[2]=true;}
                if(key==KeyEvent.VK_D) {tempObject.setVelX(4);  keyDown[3]=true;}
            }

        }

        if (key==KeyEvent.VK_ESCAPE) System.exit(1);

    }

    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();

        for(int i=0;i<handler.getSize();i++){
            GameObject tempObject=handler.getObject(i);

            if(tempObject.getId()== ID.Player){
                //key events for Player

                if(key==KeyEvent.VK_W) keyDown[0]=false;
                if(key==KeyEvent.VK_S) keyDown[1]=false;
                if(key==KeyEvent.VK_A) keyDown[2]=false;
                if(key==KeyEvent.VK_D) keyDown[3]=false;

                if (!keyDown[0] && !keyDown[1])   tempObject.setVelY(0);
                if (!keyDown[2] && !keyDown[3])   tempObject.setVelX(0);

            }

        }


    }
}
