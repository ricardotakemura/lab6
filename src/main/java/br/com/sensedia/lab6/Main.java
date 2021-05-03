package br.com.sensedia.lab6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import br.com.sensedia.lab6.model.User;
import br.com.sensedia.lab6.service.ServiceFactory;
import br.com.sensedia.lab6.service.UserService;

public class Main {

	private static User currentUser = null;

	public static void main(String[] args) throws Exception {

		System.out.print("Username: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String username = reader.readLine();
		System.out.print("Password: ");
		String password = reader.readLine();
		UserService userService = ServiceFactory.getInstance().getService(UserService.class);
		/**
		 * @TODO 5 - Implementar a interface UserServiceListener dentro do método
		 *       estático main da classe Main conforme descrito no README.md
		 */
		userService.login(username, password, new UserService.UserServiceListener() {

		    @Override
		    public void onLogin(User user) {
		        System.out.println("Usuário logado.");
		        currentUser = user;
		    }

		    @Override
		    public void onError(Throwable t) {
		        if (t instanceof UserNotFoundException) {
		            System.out.println("Usuário não encontrado.");
		        } else {
		            System.out.println("Erro geral do sistema.");
		        }
		    }
		});

		currentUser.addObservable((field, oldValue, newValue) -> System.out
				.println("O campo " + field + " tinha o valor '" + oldValue + "' e agora tem '" + newValue + "'"));
		System.out.print("Change password: ");
		String newPassword = reader.readLine();
		currentUser.setPassword(newPassword);
	}

}
