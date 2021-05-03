package br.com.sensedia.lab6.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sensedia.lab6.model.User;
import br.com.sensedia.lab6.service.exception.UserNotFoundException;

public class UserService {

	private List<User> users = new ArrayList<>();

	/**
	 * @TODO 4 - Criar interface UserServiceListener dentro da classe
	 *       br.com.sensedia.lab6.service.UserService, com os métodos onLogin e
	 *       onError
	 **/
	public interface UserServiceListener {
	    void onLogin(User user);
	    void onError(Throwable t);
	}

	protected UserService() {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("/passwd")))) {
			users = reader.lines().map(it -> {
				String[] values = it.split(";");
				User.Builder builder = new User.Builder();
				return builder.name(values[0]).password(values[1]).build();
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login(String username, String password, UserServiceListener listener) {
		try {
			listener.onLogin(
					users.stream().filter(it -> it.getName().equals(username) && it.getPassword().contentEquals(password))
							.findFirst().orElseThrow(UserNotFoundException::new));
		} catch (Throwable e) {
			listener.onError(e);
		}
	}
}
