package dio.web.api.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import dio.web.api.repository.UserRepository;
import dio.web.api.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityDatabaseService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        User userEntity = userRepository.findByUsername(login);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + login);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        userEntity.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });

        return new org.springframework.security.core.userdetails.User(
                userEntity.getLogin(), // ou getUsername() se você renomear
                userEntity.getPassword(),
                authorities);
    }
}
