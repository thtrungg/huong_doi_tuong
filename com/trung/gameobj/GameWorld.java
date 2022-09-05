/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trung.gameobj;

import com.trung.userinterface.GameFrame;
import java.awt.Graphics2D;

/**
 *
 * @author Admin
 */
public class GameWorld{
    
    
    public MainPlayer player1;
    public Map map ;
    public Camera camera;
    
    public GameWorld(){
        
        player1 = new MainPlayer(100,300,this);
        map = new Map(0,0,this);
        camera = new Camera(0,0,GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGHT,this);

}
    
    public void Update(){
        camera.Update();
        player1.Update();
    }
    
    public void Render(Graphics2D g2){
        
        map.draw(g2);      
        player1.draw(g2);


       
    }
    
    
    
}
