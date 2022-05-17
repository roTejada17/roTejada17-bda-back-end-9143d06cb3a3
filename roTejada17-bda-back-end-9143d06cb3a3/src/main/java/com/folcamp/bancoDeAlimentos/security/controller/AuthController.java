package com.folcamp.bancoDeAlimentos.security.controller;

//import antlr.Token;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.Rol;
import com.folcamp.bancoDeAlimentos.entity.User;
import com.folcamp.bancoDeAlimentos.enums.RolName;
import com.folcamp.bancoDeAlimentos.security.dto.JwtDto;
import com.folcamp.bancoDeAlimentos.security.dto.LoginUser;
import com.folcamp.bancoDeAlimentos.security.dto.NewUser;
import com.folcamp.bancoDeAlimentos.security.jwt.JwtProvider;
import com.folcamp.bancoDeAlimentos.service.RolService;
import com.folcamp.bancoDeAlimentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal ingresados o email inválido"), HttpStatus.BAD_REQUEST);

        if (userService.existsByNameUser(newUser.getNameUser()))
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);

        if (userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Mensaje("Este email ya existe"), HttpStatus.BAD_REQUEST);

        User user =
                new User(newUser.getName(), newUser.getNameUser(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        if (newUser.getRoles().contains("admin")) {
            roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
            user.setRoles(roles);
        }
        userService.save(user);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal ingresados"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getNameUser(),
                        loginUser.getPassword())
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    /*@PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
    String token = jwtProvider.refreshToken(jwtDto);
    JwtDto jwt = new JwtDto(token);
    return new ResponseEntity(jwt, HttpStatus.OK);
    }*/
}
