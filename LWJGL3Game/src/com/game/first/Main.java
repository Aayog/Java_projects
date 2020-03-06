package com.game.first;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;
public class Main implements Runnable{
	
	private int width = 1280;
	private int height = 720;
	private boolean running =false;
	private Thread thread;
	private long window;
	public void start() {
		running = false;
		thread = new Thread(this,"Game");
		thread.start();
	}
	
	public void run() {
		init();
		while(running) {
			update();
			render();
		}
	}
	
	
	private void init() {
		if(!glfwInit()) {
			
		}
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(width, height, "Flappy", NULL, NULL);
		
	}

	private void render() {
		
	}

	private void update() {
		
	}

	public static void main(String[] args) {
		new Main().start();
	}

}