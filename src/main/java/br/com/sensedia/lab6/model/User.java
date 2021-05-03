package br.com.sensedia.lab6.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private String password;
	private List<Observable> observables = new ArrayList<>();

	/**
	 * @TODO 1 - Criar uma classe interna dentro da classe
	 *       br.com.sensedia.lab6.model.User chamada Builder, de acordo com a
	 *       implementação descrita no README.md
	 */

	/**
	 * @TODO 6 - Criar uma interface dentro da classe
	 *       br.com.sensedia.lab6.model.User chamada Observable, de acordo com a
	 *       implementação descrita no README.md
	 */

	private User(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		/**
		 * @TODO 7 - Adicionar o código descrito no README.md no método setName da
		 *       classe br.com.sensedia.lab6.model.User (primeira linha do método).
		 */
		this.name = name;
	}

	public void setPassword(String password) {
		/**
		 * @TODO 8 - Adicionar o código descrito no README.md no método setPassword da
		 *       classe br.com.sensedia.lab6.model.User (primeira linha do método).
		 */
		this.password = password;
	}

	public void addObservable(Observable observable) {
		observables.add(observable);
	}

	public void removeObservable(Observable observable) {
		observables.remove(observable);
	}
}
