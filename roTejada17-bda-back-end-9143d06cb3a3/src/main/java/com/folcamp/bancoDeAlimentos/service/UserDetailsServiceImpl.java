package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.entity.User;
/*import com.folcamp.bancoDeAlimentos.security.entity.User;*/
import com.folcamp.bancoDeAlimentos.security.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("usuarioDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String nameUser) throws UsernameNotFoundException {
        User user= userService.getByNameUser(nameUser).get();
        return PrincipalUser.build(user);
    }
}
