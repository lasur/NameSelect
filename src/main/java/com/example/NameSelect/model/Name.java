package com.example.NameSelect.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="imiona")
public class Name {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String count;
    private String sex;
    private String description;
    @ManyToMany(mappedBy = "likedNamesOne")
    Set<User> likedByOne;
    @OneToMany(mappedBy = "name")
    Set<NameRating> ratings;
}
