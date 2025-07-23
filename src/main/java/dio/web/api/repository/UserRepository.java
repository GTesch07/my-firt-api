package dio.web.api.repository;

import org.springframework.stereotype.Repository;

import dio.web.api.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    public void save(User user) {
        System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        System.out.println(user);
    }

    public void update(User user) {
        System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(user);
    }

    public void remove(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User("gleyson", "password"));
        users.add(new User("frank", "masterpass"));
        return users;
    }

    public User finById(Integer id) {
        System.out.println(String.format("GET/id - Recebendo o id: %d para localizar um usuário", id));
        return new User("gleyson", "password");
    }

    public User findByUsername(String login) {
        System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuário", login));
        return new User("gleyson", "password");
    }

}
