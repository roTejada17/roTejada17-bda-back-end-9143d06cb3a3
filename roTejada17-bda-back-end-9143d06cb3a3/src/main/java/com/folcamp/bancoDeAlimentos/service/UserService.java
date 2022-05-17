package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.entity.User;
import com.folcamp.bancoDeAlimentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service/*("usuarioService")*/
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getByNameUser(String nameUser){
        return userRepository.findByNameUser(nameUser);
    }
    public boolean existsByNameUser(String nameUser){
        return userRepository.existsByNameUser(nameUser);
    }
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    public void save(User user) {
        userRepository.save(user);
    }
}
