/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trung.userinterface;

import com.trung.effect.Animation;
import com.trung.effect.CacheDataLoder;
import com.trung.effect.FrameImage;
import com.trung.gameobj.GameWorld;
import com.trung.gameobj.MainPlayer;
import com.trung.gameobj.Map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    
    private Thread thread;
    
    private boolean isRunning;
    
    private InputManeger inputManeger;
   
    private BufferedImage bufImage;
    
    private Graphics2D bufG2D;
    
    public GameWorld gameWorld;
   

    public GamePanel() throws IOException{
        
        gameWorld = new GameWorld();
        inputManeger = new InputManeger(gameWorld);  
        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

    } 
    
    
    @Override
    public void paint(Graphics g){
      g.drawImage(bufImage, 0, 0, this);
             
    }
    
    public void startGame(){
        if(thread  == null){
                isRunning = true;
                thread = new Thread(this);
                thread.start();
        }
    }
    
    public void UpdateGame(){
        gameWorld.Update();
    }
    
    public void RenderGame(){
        if(bufImage == null){
             bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
        
        if(bufImage != null){
            bufG2D = (Graphics2D) bufImage.getGraphics();
        }
        
        if(bufG2D != null){
             bufG2D.setColor(Color.RED);
             bufG2D.fillRect(0,0,GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGHT);
             
             //Ve o day:
             gameWorld.Render(bufG2D);
             

             
        }
    }
    
    @Override
    public void run() {
        
        long FPS = 80;
        long period = 1000*1000000/FPS; //don vi nano (chu ki) 1 frame nghi bao nheiu thoi gian
        long beginTime = 0;
        long sleepTime;
        
    
        
        while(isRunning){
            

         UpdateGame();         
         repaint();
         RenderGame();

         
         
         long deltaTime = System.nanoTime() - beginTime;
         sleepTime = period - deltaTime;
         
         try {
             if(sleepTime > 0 )
                 Thread.sleep(sleepTime/1000000);
             else Thread.sleep(period/2000000);
         }catch(InterruptedException ex){}
         
         beginTime = System.nanoTime();
            
        }
        
    
    }

    @Override
    public void keyTyped(KeyEvent e) {        
    }

    @Override
    public void keyPressed(KeyEvent e) { //callback method
        
        
        inputManeger.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        inputManeger.processKeyReleased(e.getKeyCode());
       
        
    }

    
}
