package com.mrlopito.senai.exam.crud.application.commands.user;


import com.mrlopito.senai.exam.crud.domain.dtos.CreateUserDTO;
import com.mrlopito.senai.exam.crud.domain.entities.SystemUser;
import com.mrlopito.senai.exam.crud.domain.repositories.UserRepository;
import com.mrlopito.senai.exam.crud.domain.utils.Encrypt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateUserCommand {

    @Inject
    private UserRepository repository;

    @Inject
    private Encrypt encrypt;

    public void handle(CreateUserDTO dto) {
        SystemUser systemUser = new SystemUser(dto.getUsername(), encrypt.encode(dto.getPassword()));

        repository.create(systemUser);
    }
}
