package main;

import java.awt.*;

public class HUD {

    private static float health=200;
    private static double healthLength;

    private static int score=0;
    private static int level=1;

    public void tick(){
        healthLength=health*0.5;    //生命与生命条的比例
        health=Game.clamp(health,0,health);
        healthLength=Game.clamp(healthLength,0,healthLength);

        score+=3;
    }

    public void render(Graphics g){
        g.setColor(new Color(0xAC2D40));
        g.fillRect(15,10,(int)healthLength,5);

        Font font=new Font("font",Font.BOLD,11);
        g.setFont(font);
        g.setColor(new Color(226, 226, 123));
        g.drawString("Score: "+score,520,15);
        g.drawString("Level : "+level,520,30);

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
