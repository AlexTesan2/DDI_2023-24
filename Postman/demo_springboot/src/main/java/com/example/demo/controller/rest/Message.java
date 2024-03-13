package com.example.demo.controller.rest;

public class Message {

	// los atributos propios de la clase
	private Integer idMessage;

	// Metodos constructores (completo y vacio
	public Message(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public Message() {
	}

	// getter y setter
	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

}
