package br.com.guidosoft.ccontrolbackend.controllers;

import br.com.guidosoft.ccontrolbackend.entities.Address;
import br.com.guidosoft.ccontrolbackend.entities.User;
import br.com.guidosoft.ccontrolbackend.repositories.AddressRepository;
import br.com.guidosoft.ccontrolbackend.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public User insert(@RequestBody User data){
        Address address = addressRepository.save(data.getAddress());
        data.setAddress(address);
        return userRepository.save(data);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    public User update(@RequestBody User data) throws ObjectNotFoundException {
        Optional<User> optionalUser = userRepository.findById(data.getId());
        User user = optionalUser.orElseThrow(() -> new ObjectNotFoundException(data, "User not found"));
        data.getAddress().setId(user.getAddress().getId());
        data.getAddress().setCreatedAt(user.getAddress().getCreatedAt());
        addressRepository.save(data.getAddress());
        data.setCreatedAt(user.getCreatedAt());
        return userRepository.save(data);
    }
}
