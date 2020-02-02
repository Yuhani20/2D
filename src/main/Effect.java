package main;

import java.awt.*;

public class Effect {

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(Color.magenta);
        g.fillRect(0,0,Game.WIDTH2,Game.HEIGHT2);
    }

}
