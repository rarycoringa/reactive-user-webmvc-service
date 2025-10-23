package br.edu.ufrn.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ufrn.user.record.CreateUserDTO;
import br.edu.ufrn.user.record.UserDTO;
import br.edu.ufrn.user.service.UserService;

@Controller
public class UserGraphQLController {

    @Autowired
    private UserService userService;

    @QueryMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }
    
    @QueryMapping
    public UserDTO getById(@Argument String id) {
        return userService.getById(id);
    }
    
    @MutationMapping
    public UserDTO save(@Argument("createUserInput") CreateUserDTO createUserDTO) {
        return userService.save(createUserDTO);
    }
    
    @MutationMapping
    public void delete(@Argument String id) {
        userService.delete(id);
    }
    
}
