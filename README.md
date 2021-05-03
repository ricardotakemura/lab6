# Design Patterns

## Aplicativo de login

### BUILDER
* TODO 1 - Criar uma classe interna dentro da classe br.com.sensedia.lab6.model.User chamada Builder, com a seguinte implementação:
```java
public static class Builder {

    private String name;
    private String password;

    public Builder name(String name) {
        this.name = name;
        return this;
    }

    public Builder password(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(name, password);
    }
}
```

## SINGLETON
* TODO 2 - Criar o método estático getInstance na classe br.com.sensedia.lab6.service.ServiceFactory que retorna uma única instância da classe:
```java
private static ServiceFactory instance;

public static ServiceFactory getInstance() {
    if (instance == null) {
        instance = new ServiceFactory();
    }
    return instance;
}
```

## FACTORY
* TODO 3 - Criar o método getService(Class&lt;T&gt; serviceClass) na classe br.com.sensedia.lab6.service.ServiceFactory que obtem uma instância de uma classe de serviço, conforme implementação:
```java
public <T> T getService(Class<T> serviceClass) {
    try {
        return serviceClass.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
} 
```

## LISTENER
* TODO 4 - Criar interface UserServiceListener dentro da classe br.com.sensedia.lab6.service.UserService, com os métodos onLogin e onError:
```java
public interface UserServiceListener {
    void onLogin(User user);
    void onError(Throwable t);
}
```

* TODO 5 - Implementar a interface UserServiceListener dentro do método estático main da classe br.com.sensedia.lab6.Main conforme abaixo:
```java
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
```

## OBSERVABLE
* TODO 6 - Criar uma interface dentro da classe br.com.sensedia.lab6.model.User chamada Observable, de acordo com a implementação abaixo:
```java	
public interface Observable {
    <T> void notify(String field, T oldValue, T newValue);
}
```

* TODO 7 - Adicionar o seguinte código no método setName da classe br.com.sensedia.lab6.model.User (primeira linha do método):
```java	
observables.stream().forEach(it -> it.notify("name", this.name, name));
```

* TODO 8 - Adicionar o seguinte código no método setPassword da classe br.com.sensedia.lab6.model.User (primeira linha do método):
```java	
observables.stream().forEach(it -> it.notify("password", this.password, password));
```