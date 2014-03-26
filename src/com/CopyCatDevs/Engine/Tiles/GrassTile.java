package com.CopyCatDevs.Engine.Tiles;

import com.CopyCatDevs.Engine.Screen;
import com.CopyCatDevs.Engine.Sprites.Sprites;

public class GrassTile extends Tile{

	public GrassTile(int id) {
		super(id);
	
		tile = Sprites.terrain[0][0];
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderSprite(x * tile.w, y * tile.h, tile);
		
	}

}
