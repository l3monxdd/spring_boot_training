package ua.com.ebooks.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String text;

    private String tag;


}
