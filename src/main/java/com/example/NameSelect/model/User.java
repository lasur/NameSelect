package com.example.NameSelect.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name="usertable",schema="public")
public class User {
    public User(@NotEmpty String username, @NotEmpty String password, @Email @NotEmpty String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @Email
    @NotEmpty
    private String email;
    @ManyToMany
    @JoinTable(
            name = "id_table",
            joinColumns = @JoinColumn(name = "id_username"),
            inverseJoinColumns = @JoinColumn(name = "id_im"))
    List<Name> likedNamesOne;
    @OneToMany(mappedBy = "user")
    List<NameRating> ratings;
}
