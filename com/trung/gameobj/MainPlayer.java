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
public class MainPlayer extends Nguoi {

    public static final int RUNSPEED = 3;

    

    
    public MainPlayer(float x, float y, GameWorld gameWorld) {
        super(x, y, 70, 90, 0.2f, 100, gameWorld);
        
        setTeamType(LEAGUE_TEAM);

        setTimeForNoBehurt(2000*10000000);
        
        
        
    }

  

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
     
        Rectangle rect = getBoundForCollisionWithMap();
        
        if(getIsDicking()){
            rect.x = (int) getPosX() - 22;
            rect.y = (int) getPosY() - 20;
            rect.width = 44;
            rect.height = 65;
        }else{
            rect.x = (int) getPosX() - 22;
            rect.y = (int) getPosY() - 40;
            rect.width = 44;
            rect.height = 80;
        }
        
        return rect;
     
    }

    @Override
    public void draw(Graphics2D g2) {
        
       
        
        drawBoundForCollisionWithMap(g2);
//        drawBoundForCollisionWithEnemy(g2);
    }
    
    
    @Override
    public void Update() {

        super.Update();
        
        
        
//        if(isShooting){
//            if(System.nanoTime() - lastShootingTime > 500*1000000){
//                isShooting = false;
//            }
//        }
        
//        if(getIsLanding()){
//            landingBackAnim.Update(System.nanoTime());
//            if(landingBackAnim.isLastFrame()) {
//                setIsLanding(false);
//                landingBackAnim.reset();
//                runForwardAnim.reset();
//                runBackAnim.reset();
//            }
//        }
//        
    }
    
    @Override
    public void run() {
        if(getDirection() == LEFT_DIR)
            setSpeedX(-3);
        else setSpeedX(3);
    }

    @Override
    public void jump() {
        
        if(!getIsJumping()){
            setIsJumping(true);
            setSpeedY(-5.0f);           
           
        }
//         for clim wall
        else{
            Rectangle rectRightWall = getBoundForCollisionWithMap();
            rectRightWall.x += 1;
            Rectangle rectLeftWall = getBoundForCollisionWithMap();
            rectLeftWall.x -= 1;
            
            if(getGameWorld().map.haveCollisionWithRightWall(rectRightWall)!=null && getSpeedX() > 0){
                setSpeedY(-5.0f);
                setSpeedX(-1);
             
               setDirection(LEFT_DIR);
            }else if(getGameWorld().map.haveCollisionWithLeftWall(rectLeftWall)!=null && getSpeedX() < 0){
                setSpeedY(-5.0f);
               setSpeedX(1);              
               setDirection(RIGHT_DIR);
           }
                
       }

        
    }
    

    @Override
    public void dick() {
        if(!getIsJumping())
            setIsDicking(true);
    }

    @Override
    public void standUp() {
        setIsDicking(false);
       
    }

    @Override
    public void stopRun() {
        setSpeedX(0);
   
    }

//    @Override
//    public void attack() {
//    
//        if(!isShooting && !getIsDicking()){
//            
//            shooting1.play();
//            
//            Bullet bullet = new BlueFire(getPosX(), getPosY(), getGameWorld());
//            if(getDirection() == LEFT_DIR) {
//                bullet.setSpeedX(-10);
//                bullet.setPosX(bullet.getPosX() - 40);
//                if(getSpeedX() != 0 && getSpeedY() == 0){
//                    bullet.setPosX(bullet.getPosX() - 10);
//                    bullet.setPosY(bullet.getPosY() - 5);
//                }
//            }else {
//                bullet.setSpeedX(10);
//                bullet.setPosX(bullet.getPosX() + 40);
//                if(getSpeedX() != 0 && getSpeedY() == 0){
//                    bullet.setPosX(bullet.getPosX() + 10);
//                    bullet.setPosY(bullet.getPosY() - 5);
//                }
//            }
//            if(getIsJumping())
//                bullet.setPosY(bullet.getPosY() - 20);
//            
//            bullet.setTeamType(getTeamType());
//            getGameWorld().bulletManager.addObject(bullet);
//            
//            lastShootingTime = System.nanoTime();
//            isShooting = true;
//            
//        }

    @Override
    public void attack() {}
    
    public void hurtingCallBack(){}
    
    }


