package de.hhu.propra12.gruppe25.bomberman.gui;

public class Game {
	public void main(){
		new Game();
	}
	public Game(){
		new Grafik();
		new Logik();
		new Menu();
		new Steuerung();
	}
}
