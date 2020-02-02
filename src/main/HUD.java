package main;

import java.awt.*;

public class HUD {

    public static int HEALTH=100;
    private int greenValue=255;

    private int score=0;
    private int level=1;

    public void tick(){
        HEALTH=Game.clamp(HEALTH,0,100);
        greenValue=Game.clamp(greenValue,0,255);

        greenValue=HEALTH*2;

        score+=3;
    }

    public void render(Graphics g){
        g.setColor(new Color(100,greenValue,0));
        g.fillRect(10,10,HEALTH,5);

        g.setColor(new Color(255,255,153));
        g.drawString("Score: "+score,540,13);
        g.drawString("Level : "+level,540,25);

    }

    public void setScore(int score){
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }


}
