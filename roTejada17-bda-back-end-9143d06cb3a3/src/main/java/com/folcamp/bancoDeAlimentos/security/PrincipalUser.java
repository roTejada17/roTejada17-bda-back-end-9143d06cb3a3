package com.folcamp.bancoDeAlimentos.security;

import com.folcamp.bancoDeAlimentos.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipalUser implements UserDetails {
    private Long id;
    private String name;
    private String nameUser;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(Long id, String name, String nameUser, String email, Collection<? extends GrantedAuthority>
            authorities) {
        this.id=id;
        this.name = name;
        this.nameUser = nameUser;
        this.email = email;
        this.password = null;
        this.authorities = authorities;
    }

    public static PrincipalUser build(User user){
        List<GrantedAuthority> authorities=
                user.getRoles()
                        .stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getRolName().name()))
                        .collect(Collectors.toList());
        return new PrincipalUser(user.getId(), user.getName(), user.getNameUser(),user.getEmail(), authorities);
    }
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nameUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}