package com.example.NameSelect;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(Long id_im, Long id_username)
    {
        entityManager.joinTransaction();
        entityManager.createNativeQuery("INSERT INTO id_table(id_im,id_username) VALUES (?,?)")
        .setParameter(1, id_im)
        .setParameter(2, id_username)
        .executeUpdate();
    }

    @Transactional
    public void delete(Long id_im, Long id_username)
    {
        entityManager.joinTransaction();
        entityManager.createNativeQuery("delete from id_table where id_im= ? and id_username= ?")
                .setParameter(1, id_im)
                .setParameter(2, id_username)
                .executeUpdate();
    }

    @Transactional
    public void insert2(Long id_im, Long id_username)
    {
        entityManager.joinTransaction();
        entityManager.createNativeQuery("insert into id_table2(id_im2,id_username2) values(?,? )")
                .setParameter(1, id_im)
                .setParameter(2, id_username)
                .executeUpdate();
    }

    @Transactional
    public void delete2(Long id_im, Long id_username)
    {
        entityManager.joinTransaction();
        entityManager.createNativeQuery("delete from id_table2 where id_im2= ? and id_username2= ?")
                .setParameter(1, id_im)
                .setParameter(2, id_username)
                .executeUpdate();
    }

    @Transactional
    public void update(int note, Long id_im, Long id_username)
    {
        entityManager.joinTransaction();
        entityManager.createNativeQuery("update id_table2 set note= ? where id_im2= ? and id_username2= ?")
                .setParameter(1, note)
                .setParameter(2,id_im )
                .setParameter(3,id_username)
                .executeUpdate();
    }
}