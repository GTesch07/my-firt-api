package dio.web.api.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dio.web.api.model.User;
import dio.web.api.repository.UserRepository;

@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = repository.findByUsername("admin");
        if (user == null) {
            user = new User();
            user.setName("ADMIN");
            user.setLogin("admin"); // Use setLogin se for o campo correto
            user.setPassword("admin123");
            repository.save(user);
        }

        user = repository.findByUsername("user");
        if (user == null) {
            user = new User();
            user.setName("USER");
            user.setLogin("user"); // Use setLogin se for o campo correto
            user.setPassword("user123");
            repository.save(user);
        }
    }
}
