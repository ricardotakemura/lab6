package br.com.sensedia.lab6.service;

public class ServiceFactory {

	private ServiceFactory() {
	}

	/**
	 * @TODO 2 - Criar o método estático getInstance da classe ServiceFactory que
	 *       retorna uma única instância da classe.
	 */
	private static ServiceFactory instance;

	public static ServiceFactory getInstance() {
	    if (instance == null) {
	        instance = new ServiceFactory();
	    }
	    return instance;
	}

	/**
	 * @TODO 3 - Criar o método getService(Class&lt;T&gt; serviceClass) na classe
	 *       br.com.sensedia.lab6.service.ServiceFactory que obtem uma instância de
	 *       uma classe de serviço, conforme implementação do README.md.
	 */
	public <T> T getService(Class<T> serviceClass) {
	    try {
	        return serviceClass.getDeclaredConstructor().newInstance();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}
