package com.mrlopito.senai.exam.crud.application.commands.auth;

import com.mrlopito.senai.exam.crud.domain.dtos.AuthenticateUserDTO;
import com.mrlopito.senai.exam.crud.domain.entities.SystemUser;
import com.mrlopito.senai.exam.crud.domain.repositories.UserRepository;
import com.mrlopito.senai.exam.crud.domain.response.AuthUserResponse;
import com.mrlopito.senai.exam.crud.domain.utils.Encrypt;
import com.mrlopito.senai.exam.crud.domain.utils.TokenUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class AuthenticateUserCommand {


    @ConfigProperty(name = "com.senai.users.password.secret")  private String secret;
    @ConfigProperty(name = "com.senai.users.password.iteration")  private Integer iteration;
    @ConfigProperty(name = "com.senai.users.password.keylength")  private Integer keylength;

    @ConfigProperty(name = "com.senai.users.jwt.duration") public Long duration;
    @ConfigProperty(name = "mp.jwt.verify.issuer") public String issuer;
    @Inject
    private UserRepository userRepository;

    @Inject
    private Encrypt encrypt;


    public AuthUserResponse handle(AuthenticateUserDTO dto) throws Exception {
        SystemUser user = userRepository.retriveByUsername(dto.getUsername());

        if(user == null || !user.getPassword().equals(encrypt.encode(dto.getPassword()))){
            throw new Exception("not authorized");
        }

        return new AuthUserResponse(TokenUtils.generateToken(user.getUsername(), duration, issuer), user);
    }
}
