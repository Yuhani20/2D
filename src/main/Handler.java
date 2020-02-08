package main;

import GameObjects.GameObject;
import GameObjects.ID;
import GameObjects.Player;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private LinkedList<GameObject> objects=new LinkedList<GameObject>();

    public void tick(){
        for (int i=0;i< objects.size();i++){
            GameObject tempObject=objects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject=objects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        objects.add(object);
    }

    public void removeObject(GameObject object){
        objects.remove(object);
    }

    public void cleanEnemies(){
        for(int i=0;i<objects.size();i++){
            GameObject tempObject=objects.get(i);

            if (tempObject.getId()== ID.Player){
                objects.clear();
                addObject(new Player((int)tempObject.getX(),(int)tempObject.getY(),ID.Player,this));
            }

        }

    }

    public int getSize(){
        return objects.size();
    }

    public GameObject getObject(int i){
        return objects.get(i);
    }
}
