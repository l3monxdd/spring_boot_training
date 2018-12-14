package ua.com.ebooks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ebooks.entity.Message;

import java.util.List;

public interface MessageDao extends JpaRepository<Message, Integer > {

    List<Message> findByTag(String tag);
}
