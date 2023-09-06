package br.com.guidosoft.ccontrolbackend.repositories;

import br.com.guidosoft.ccontrolbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
