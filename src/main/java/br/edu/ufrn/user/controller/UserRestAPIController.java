package br.edu.ufrn.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufrn.user.record.CreateUserDTO;
import br.edu.ufrn.user.record.UserDTO;
import br.edu.ufrn.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestAPIController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable String id) {
        return userService.getById(id);
    }
    
    @PostMapping
    public UserDTO save(@RequestBody CreateUserDTO createUserDTO) {
        return userService.save(createUserDTO);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

}
