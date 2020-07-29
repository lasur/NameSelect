package com.example.NameSelect;

import com.example.NameSelect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u.id FROM User u WHERE u.username=:usernameOrEmail OR u.email=:usernameOrEmail")
    Long getIdFromDB(String usernameOrEmail);

    @Query("SELECT u.password FROM User u WHERE u.username=:usernameOrEmail OR u.email=:usernameOrEmail")
    String getPasswordFromDB(String usernameOrEmail);
}