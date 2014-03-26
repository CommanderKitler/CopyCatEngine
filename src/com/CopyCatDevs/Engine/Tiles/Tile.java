package com.CopyCatDevs.Engine.Tiles;

import com.CopyCatDevs.Engine.Screen;
import com.CopyCatDevs.Engine.Sprites.Sprite;

public class Tile {
	public final int id;
	public Sprite tile;
	
	public static Tile[] tiles = new Tile[25000];
	
 	public static Tile grassTile = new GrassTile(0);
	public static Tile rockTile = new RockTile(1);
 	
	public Tile(int id){
		this.id = id;
		tiles[id] = this;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
}
