package br.com.sensedia.lab6.service.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("Usuário não encontrado");
	}

}
