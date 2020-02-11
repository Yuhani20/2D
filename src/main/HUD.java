package main;

import java.awt.*;

public class HUD {

    private static float health=100;
    private float greenValue=255;

    private static int score=0;
    private static int level=1;

    public void tick(){
        health=Game.clamp(health,0,100);
        greenValue=Game.clamp(greenValue,0,255);

        greenValue=health*2;

        score+=3;
    }

    public void render(Graphics g){
        g.setColor(new Color(100,(int)greenValue,0));
        g.fillRect(10,10,(int)health,5);

        g.setColor(new Color(255,255,153));
        g.drawString("Score: "+score,540,13);
        g.drawString("Level : "+level,540,25);

    }

    public static void setScore(int score){
        HUD.score=score;
    }

    public static int getScore() {
        return score;
    }

    public static void setLevel(int level) {
        HUD.level = level;
    }

    public static int getLevel() {
        return level;
    }

    public static void setHealth(float health) {
        HUD.health = health;
    }

    public static float getHealth() {
        return health;
    }

}
