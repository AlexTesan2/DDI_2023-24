package com.example.demo.examen.dragonball;

class DragonBall {
	private String ubicacion;
	private int ball;

	public DragonBall(String ubicacion, int ball) {
		this.ubicacion = ubicacion;
		this.ball = ball;
	}

	public DragonBall() {
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getNumEstrellas() {
		return ball;
	}

	public void setNumEstrellas(int ball) {
		this.ball = ball;
	}
}