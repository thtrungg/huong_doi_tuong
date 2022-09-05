
package com.trung.userinterface;

import com.trung.gameobj.GameWorld;
import com.trung.gameobj.MainPlayer;
import java.awt.event.KeyEvent;

/**
 *
 * @author Admin
 */
public class InputManeger {
    
    private GameWorld gameWorld;
    
    public InputManeger( GameWorld gameworld ){
        this.gameWorld  = gameworld;
    }
    
    public void processKeyPressed(int keyCode){
        
        switch(keyCode){
            
            case KeyEvent.VK_A -> {
                
                gameWorld.player1.setDirection(gameWorld.player1.LEFT_DIR);
                gameWorld.player1.setSpeedX(-3);
                gameWorld.player1.setPosX(gameWorld.player1.getPosX() - 3);
                System.out.println("An nut A");

                break;
            }
                
            case KeyEvent.VK_D -> {
                gameWorld.player1.setDirection(gameWorld.player1.RIGHT_DIR);
                gameWorld.player1.setSpeedX(3);
                gameWorld.player1.setPosX(gameWorld.player1.getPosX() + 3);
                break;
            }
            case KeyEvent.VK_S -> {
                break;
            }
            
            case KeyEvent.VK_W -> {
                break;
            }
            case KeyEvent.VK_E ->{
                gameWorld.player1.setSpeedY(-3);
                gameWorld.player1.setPosY(gameWorld.player1.getPosX() - 3);
                break;
            }            
        }
    }
    
   
    public void processKeyReleased(int keyCode){
        
        switch(keyCode){
            
            case KeyEvent.VK_A -> {
                 gameWorld.player1.setDirection(gameWorld.player1.LEFT_DIR);
                gameWorld.player1.stopRun();
                System.out.println("Tha nut A");
                break;
            }
                
            case KeyEvent.VK_D -> {
                  gameWorld.player1.setDirection(gameWorld.player1.RIGHT_DIR);
                gameWorld.player1.stopRun();
                break;
            }
            case KeyEvent.VK_S -> {
                break;
            }
            
            case KeyEvent.VK_W -> {
                break;
            }
            case KeyEvent.VK_E ->{
                
                break;
            }            
        }    
        }

}

          