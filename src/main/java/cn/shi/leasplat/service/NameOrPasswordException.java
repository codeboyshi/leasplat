package cn.shi.leasplat.service;


public class NameOrPasswordException extends RuntimeException{

	public NameOrPasswordException(){}
	
	public NameOrPasswordException(String message, Throwable cause){
		super(message, cause);
	}
	public NameOrPasswordException(String message){
		super(message);
	}
	

}
