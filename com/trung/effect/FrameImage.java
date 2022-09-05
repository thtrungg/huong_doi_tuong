/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trung.effect;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class FrameImage {
    
    private String name;
    private BufferedImage image;
    
    public FrameImage(){
        image = null;
        name = null;
    }
    
    public FrameImage(String name, BufferedImage image){
        this.name = name;
        this.image = image;
    }
    
    public FrameImage(FrameImage frameImage){
        image = new BufferedImage(frameImage.getImageWidth(),frameImage.getImageHight(),frameImage.getImage().getType());
        Graphics g = image.getGraphics();
        g.drawImage(frameImage.image, 0, 0, null);
        name = frameImage.name;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public int getImageWidth(){
        return image.getWidth();
    }
    
    public int getImageHight(){
        return image.getHeight();
    }
    
    public void drawImage(Graphics2D g2, int x, int y){
        g2.drawImage(image, x - image.getWidth()/2, y - image.getHeight()/2,null);
    }   

 
 }
