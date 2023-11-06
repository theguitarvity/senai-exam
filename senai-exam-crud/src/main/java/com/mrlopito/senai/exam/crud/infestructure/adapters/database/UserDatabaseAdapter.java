package com.mrlopito.senai.exam.crud.infestructure.adapters.database;

import com.mrlopito.senai.exam.crud.domain.entities.SystemUser;
import com.mrlopito.senai.exam.crud.domain.repositories.UserRepository;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class UserDatabaseAdapter implements UserRepository {
    @Override
    @Transactional
    public void create(SystemUser systemUser) {
        SystemUser.persist(systemUser);
    }

    @Override
    public SystemUser retriveByUsername(String username) {
        return SystemUser.find("username", username).firstResult();
    }
}
