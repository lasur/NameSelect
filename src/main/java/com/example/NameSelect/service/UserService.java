package com.example.NameSelect.service;

import com.example.NameSelect.CustomUserRepository;
import com.example.NameSelect.UserRepository;
import com.example.NameSelect.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserRepository customUserRepository;

    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Long getIdFromDB(String usernameOrEmail) {
        Long id;
        try {
            id = userRepository.getIdFromDB(usernameOrEmail);
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

    public void insertIntoTable1(Long id_im, Long id_username)
    {
        customUserRepository.insert(id_im,id_username);
    }

    public void deleteFromTable1(Long id_im, Long id_username)
    {
        customUserRepository.delete(id_im,id_username);
    }

    public void insertIntoTable2(Long id_im, Long id_username)
    {
        customUserRepository.insert2(id_im,id_username);
    }

    public void deleteFromTable2(Long id_im, Long id_username)
    {
        customUserRepository.delete2(id_im,id_username);
    }

    public void updateTable2(int note, Long id_im, Long id_username)
    {
        customUserRepository.update(note, id_im,id_username);
    }

    public boolean validate(UserBean userBean)
    {
        String password = userBean.getPassword();
        try{
             String passwordFromDB = userRepository.getPasswordFromDB(userBean.getUsername());
             BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
             if (encoder.matches(password, passwordFromDB)) {
                 return true;
             }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
