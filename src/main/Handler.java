package main;

import GameObjects.GameObject;
import GameObjects.ID;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private LinkedList<GameObject> objects=new LinkedList<GameObject>();

    //The flowing 2 methods cant be replaced with enhanced for, or it couldn't run.
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

    public void removeObject(){
        objects.remove();
    }

    public void cleanEnemies(){
        for(int i=0;i<objects.size();i++){

            GameObject tempObject=objects.get(i);
            if (tempObject.getId() != ID.Player) {
                objects.remove(tempObject);
                i--;
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
