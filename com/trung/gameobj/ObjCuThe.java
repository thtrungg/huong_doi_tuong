/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trung.gameobj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Admin
 */
public abstract class ObjCuThe extends GameObj {

    public static final int LEAGUE_TEAM = 1;
    public static final int ENEMY_TEAM = 2;
    
    public static final int LEFT_DIR = 0;
    public static final int RIGHT_DIR = 1;

    public static final int ALIVE = 0;
    public static final int BEHURT = 1;
    public static final int DEATH = 3;
    public static final int NOBEHURT = 4;
    private int state = ALIVE;
    
    private float width;
    private float height;
    private float mass;
    private float speedX;
    private float speedY;
    private int blood;
    
    private int damage;
    
    private int direction;
    
//    protected Animation behurtForwardAnim, behurtBackAnim;
    
    private int teamType;
    
    private long startTimeNoBeHurt;
    private long timeForNoBeHurt;

    public ObjCuThe(float posX, float posY, float width, float height, float mass, int blood, GameWorld gameWorld){

        // posX and posY are the middle coordinate of the object
        super(posX, posY, gameWorld);
        
        this.width= width;
        this.height= height;
        this.mass= mass;
        this.blood = blood;
        
        direction = RIGHT_DIR;

    }
    
    public void setTimeForNoBehurt(long time){
        timeForNoBeHurt = time;
    }
    
    public long getTimeForNoBeHurt(){
        return timeForNoBeHurt;
    }
    
    public void setState(int state){
        this.state = state;
    }
    
    public int getState(){
        return state;
    }
    
    public void setDamage(int damage){
            this.damage = damage;
    }

    public int getDamage(){
            return damage;
    }

    
    public void setTeamType(int team){
        teamType = team;
    }
    
    public int getTeamType(){
        return teamType;
    }
    
    public void setMass(float mass){
        this.mass = mass;
    }

    public float getMass(){
            return mass;
    }

    public void setSpeedX(float speedX){
        this.speedX = speedX;
    }

    public float getSpeedX(){
        return speedX;
    }

    public void setSpeedY(float speedY){
        this.speedY = speedY;
    }

    public float getSpeedY(){
        return speedY;
    }

    public void setBlood(int blood){
        if(blood>=0)
                this.blood = blood;
        else this.blood = 0;
    }

    public int getBlood(){
        return blood;
    }

    public void setWidth(float width){
        this.width = width;
    }

    public float getWidth(){
        return width;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public float getHeight(){
        return height;
    }
    
    public void setDirection(int dir){
        direction = dir;
    }
    
    public int getDirection(){
        return direction;
    }
    
    public abstract void attack();
    
    
    public Rectangle getBoundForCollisionWithMap(){
        Rectangle bound = new Rectangle();
        bound.x = (int) (getPosX() - (getWidth()/2));
        bound.y = (int) (getPosY() - (getHeight()/2));
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
        return bound;
    }

    public void beHurt(int damgeEat){
        setBlood(getBlood() - damgeEat);
        state = BEHURT;
        hurtingCallback();
    }

    @Override
    public void Update(){
        switch(state){
            case ALIVE: break;
            
            case DEATH: break;
 
            case NOBEHURT:
                System.out.println("state = nobehurt");
                if(System.nanoTime() - startTimeNoBeHurt > timeForNoBeHurt)
                    state = ALIVE;
                break;
        }
        
    }

    public void drawBoundForCollisionWithMap(Graphics2D g2){
        Rectangle rect = getBoundForCollisionWithMap();
        g2.setColor(Color.BLUE);
//        g2.drawRect(200, 200, 100, 50);
        g2.drawRect(rect.x - (int) getGameWorld().camera.getPosX(), rect.y - (int) getGameWorld().camera.getPosY(), rect.width, rect.height);
    }

    public void drawBoundForCollisionWithEnemy(Graphics2D g2){
        Rectangle rect = getBoundForCollisionWithEnemy();
        g2.setColor(Color.WHITE);
//        g2.drawRect(200, 200, 80, 30);
        g2.drawRect(rect.x - (int) getGameWorld().camera.getPosX(), rect.y - (int) getGameWorld().camera.getPosY(), rect.width, rect.height);
    }

    public abstract Rectangle getBoundForCollisionWithEnemy();

    public abstract void draw(Graphics2D g2);
    
    public void hurtingCallback(){};
	
}