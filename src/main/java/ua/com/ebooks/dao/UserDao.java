package ua.com.ebooks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ebooks.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
