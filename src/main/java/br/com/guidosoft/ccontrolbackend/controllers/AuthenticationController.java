package br.com.guidosoft.ccontrolbackend.controllers;

import br.com.guidosoft.ccontrolbackend.entities.Address;
import br.com.guidosoft.ccontrolbackend.entities.User;
import br.com.guidosoft.ccontrolbackend.infra.security.TokenService;
import br.com.guidosoft.ccontrolbackend.records.AuthenticationDTO;
import br.com.guidosoft.ccontrolbackend.records.LoginResponseDTO;
import br.com.guidosoft.ccontrolbackend.repositories.AddressRepository;
import br.com.guidosoft.ccontrolbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User data){
        if(this.userRepository.findByUserName(data.getUserName()) != null) return ResponseEntity.badRequest().build();

        Address address = addressRepository.save(data.getAddress());
        data.setAddress(address);

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        data.setPassword(encryptedPassword);

        this.userRepository.save(data);

        return ResponseEntity.ok().build();
    }

}
