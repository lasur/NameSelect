package com.example.NameSelect.service;

import java.util.List;

import com.example.NameSelect.NameRepository;
import com.example.NameSelect.model.Name;
import com.example.NameSelect.model.NameRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    @Autowired
    private NameRepository repository;

    public List<Name> findAll() {
        return repository.findAll();
    }

    public List<Name> getNamesByUserId(Long user_id) {
        return repository.getNamesByUserId(user_id);
    }

    public List<NameRating> getNames2ByUserId(Long user_id) {
        return repository.getNames2ByUserId(user_id);
    }
}