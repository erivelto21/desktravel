package br.com.desktravel.exception;

import javax.servlet.ServletException;

public class DeskTravelServletException extends ServletException{
	
	public DeskTravelServletException(String msg){
		super(msg);
	}
	
	public DeskTravelServletException(){
		super();
	}
}
