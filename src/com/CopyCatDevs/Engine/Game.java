package com.CopyCatDevs.Engine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.CopyCatDevs.Engine.Level.Level;
import com.CopyCatDevs.Engine.Sprites.Sprite;
import com.CopyCatDevs.Engine.Sprites.SpriteSheetLoader;
import com.CopyCatDevs.Engine.Sprites.Sprites;


public class Game extends Canvas implements Runnable {
private static final long serialVersionUID = 1L;
	
	public static final int HEIGHT = 480;
	public static final int WIDTH = 720;
	public static final int SCALE = 3;

	public static final String NAME = "Pixel Engine";
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public SpriteSheetLoader loader;
	private Screen screen;
	public Level level;
	private boolean running = false;
	Random random = new Random();
	
    public void start(){
		running = true;
		new Thread(this).start();
	}
    
    public Game() {	
    }
    
    public void init() {

    	
    	loader = new SpriteSheetLoader();
    	screen = new Screen(WIDTH, HEIGHT);
    	
    	level = new Level(16,16);

    		}
    	
    	
    	
    
	public void run() {
		init();
		while(running){
			tick();
			render();
			
			try{
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop(){
		running = false;
		
	}
	
	public void tick(){
		}
		
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		level.renderBackground(0, 0, screen);
		
		for(int y = 0; y < screen.h; y++){
			for(int x = 0; x < screen.w; x++){
				pixels[x+(y*WIDTH)] =screen.pixels[x+(y*screen.w)];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
		}
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(NAME);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		
		game.start();
		
		
		
	}
}
