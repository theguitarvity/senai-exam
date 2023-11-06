package com.mrlopito.senai.exam.crud.infestructure.adapters.utils;

import com.mrlopito.senai.exam.crud.domain.utils.Encrypt;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jodd.crypt.BCrypt;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Singleton
public class BCrypterAdapter implements Encrypt {
    @ConfigProperty(name = "com.senai.users.password.secret")  private String secret;
    @ConfigProperty(name = "com.senai.users.password.iteration")  private Integer iteration;
    @ConfigProperty(name = "com.senai.users.password.keylength")  private Integer keylength;
    @Override
    public String hash(String plain) {
        return BCrypt.hashpw(plain, BCrypt.gensalt());
    }

    @Override
    public String encode(CharSequence cs) {
        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), secret.getBytes(), iteration, keylength))
                    .getEncoded();
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
    }
}
