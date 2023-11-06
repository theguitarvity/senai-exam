package com.mrlopito.senai.exam.crud.domain.repositories;

import com.mrlopito.senai.exam.crud.domain.entities.SystemUser;

public interface UserRepository {
    public void create(SystemUser systemUser);
    public SystemUser retriveByUsername(String username);
}
