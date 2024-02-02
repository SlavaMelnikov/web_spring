package by.melnikov.myspringweb.repository;

import by.melnikov.myspringweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUsersByBirthdate(LocalDate birthdate);
}
