/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trung.userinterface;

import com.trung.effect.CacheDataLoder;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class GameFrame extends JFrame {
    
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH = 800;
    
    public GamePanel gamepanel;
    
    public GameFrame() throws IOException{
       
       Toolkit toolkit  = this.getToolkit();
       Dimension dimension = toolkit.getScreenSize();
       this.setBounds((dimension.width - SCREEN_WIDTH)/2 , (dimension.height - SCREEN_HEIGHT)/2 , SCREEN_WIDTH, SCREEN_HEIGHT); //Dat man hinh choi o giua man hinh.
       
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        try {
            CacheDataLoder.getInstance().LoadData();
        } catch (IOException ex) {
        }
       
       gamepanel = new GamePanel();
       add(gamepanel);
       
       this.addKeyListener(gamepanel);
       
  
    }
    
    public void startGame(){
        gamepanel.startGame();
    }
    
    public static void main(String args[]) throws IOException{
        
      GameFrame gameframe = new GameFrame();
      gameframe.setVisible(true);
      gameframe.startGame();
      
      
    }
    
    
}
