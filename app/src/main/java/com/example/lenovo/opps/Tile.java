package com.example.lenovo.opps;

public class Tile {
	public float x,y,width,height,speed;
	public boolean iscollidable,isDanger,autoIncrement;
	public int a,r,g,b;
	public int col;
	public Tile(float x, float y, float width, float height, float speed,int col,
			int a, int r, int g, int b) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.col = col;
		this.a = a;
		this.r = r;
		this.g = g;
		this.b = b;
		this.iscollidable=true;
		this.isDanger=false;
		this.autoIncrement=true;
	}
	public void setARGB(int a, int r, int g, int b){
		this.a = a;
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
