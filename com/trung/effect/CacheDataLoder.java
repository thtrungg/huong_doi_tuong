/*`
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trung.effect;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class CacheDataLoder {
    
    public static CacheDataLoder instance;
    
    private String framefile = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\ProjectCuoiKi\\src\\main\\java\\data\\frame.txt";
    private String animationfile = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\ProjectCuoiKi\\src\\main\\java\\data\\aniamtion.txt";
    private String mapfile = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\ProjectCuoiKi\\src\\main\\java\\data\\Map.txt";
    
    public static CacheDataLoder getInstance(){
        if(instance == null)
            instance = new CacheDataLoder();
        return instance;
    }
    
    private Hashtable<String, FrameImage> frameImages;
    private Hashtable<String, Animation> animations;
    private int[][] phys_map;
    
    private CacheDataLoder(){}
    
        public void LoadData()throws IOException{
        
        LoadFrame();
        LoadAnimation();
        LoadPhysMap();
        
    }
        
    public int[][] getMap(){
        return instance.phys_map;
    }
    
    public void LoadPhysMap() throws IOException{
        
        FileReader fr = new FileReader(mapfile);
        BufferedReader br = new BufferedReader(fr);
        
        String line = null;
        
        line = br.readLine();
        int numberOfRows = Integer.parseInt(line);
        line = br.readLine();
        int numberOfColumns = Integer.parseInt(line);
            
        
        instance.phys_map = new int[numberOfRows][numberOfColumns];
        
        for(int i = 0;i < numberOfRows;i++){
            line = br.readLine();
            String [] str = line.split(" ");
            for(int j = 0;j<numberOfColumns;j++)
                instance.phys_map[i][j] = Integer.parseInt(str[j]);
        }
        
        for(int i = 0;i < numberOfRows;i++){
            for(int j = 0;j<numberOfColumns;j++)
                System.out.print(" "+instance.phys_map[i][j]);
            
            System.out.println();
        }
        
        br.close();
        
    }
    
    
    
    
       public void LoadFrame() throws IOException {
        
        frameImages = new Hashtable<String, FrameImage>();

        FileReader fr = new FileReader(framefile);
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        if (br.readLine() == null) {
            System.out.println("No data");
            throw new IOException();
        }
        else {
            fr = new FileReader(framefile);
            br = new BufferedReader(fr);

            while((line = br.readLine()).equals(""));
            
            int n = Integer.parseInt(line);

            String path;
            ArrayList paths = new ArrayList<String>();
            Hashtable imageSources = new Hashtable<String, BufferedImage>();            

            for (int i = 0; i < n; i++) {

                FrameImage frame = new FrameImage();
                while((line = br.readLine()).equals(""));
                frame.setName(line);

                while((line = br.readLine()).equals(""));
                String[] str = line.split(" ");
                path = str[1];
                
                BufferedImage image = ImageIO.read(new File(path));
                frame.setImage(image);
                instance.frameImages.put(frame.getName(), frame);
            }

        }
        br.close();
    }
    
    public FrameImage getFrameImage(String name){
        FrameImage frameImage = new FrameImage(instance.frameImages.get(name));
        return frameImage;

    }
    
    public void LoadAnimation() throws IOException {
        
        animations = new Hashtable<String, Animation>();
        
        FileReader fr = new FileReader(animationfile);
        BufferedReader br = new BufferedReader(fr);
        
        String line = null;
        
        if(br.readLine()==null) {
            System.out.println("No data");
            throw new IOException();
        }
        else {
            
            fr = new FileReader(animationfile);
            br = new BufferedReader(fr);
            
            while((line = br.readLine()).equals(""));
            int n = Integer.parseInt(line);
            
            for(int i = 0;i < n; i ++){
                
                Animation animation = new Animation();
                
                while((line = br.readLine()).equals(""));
                animation.setName(line);
                
                while((line = br.readLine()).equals(""));
                String[] str = line.split(" ");
                
                for(int j = 0;j<str.length;j+=2)
                    animation.add(getFrameImage(str[j]), Double.parseDouble(str[j+1]));
                
                instance.animations.put(animation.getName(), animation);
                
            }
            
        }
        
        br.close();
  }
    
     public Animation getAnimation(String name){
        Animation animation = new Animation(instance.animations.get(name));
        return animation;
        
    }
    

    
    
    
}