package com.example.NameSelect;

import com.example.NameSelect.model.Name;
import com.example.NameSelect.model.NameRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NameRepository extends JpaRepository<Name, Long> {
    @Override
    List<Name> findAll();

    @Query("SELECT u.likedNamesOne FROM User u WHERE u.id=:user_id ")
    List<Name> getNamesByUserId(Long user_id);

    @Query("SELECT u.ratings FROM User u WHERE u.id=:user_id ")
    List<NameRating> getNames2ByUserId(Long user_id);
}