package by.jrr.repository;

import by.jrr.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    List<User> findByIdIsGreaterThan(Long id);
}
