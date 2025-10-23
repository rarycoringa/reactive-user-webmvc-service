package br.edu.ufrn.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufrn.user.model.User;
import br.edu.ufrn.user.record.CreateUserDTO;
import br.edu.ufrn.user.record.UserDTO;
import br.edu.ufrn.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        return userRepository.findAll()
            .stream()
            .map(user -> new UserDTO(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getCreatedAt()
                ))
            .toList();
    }

    public UserDTO getById(String id) {
        User user = userRepository.findById(id).get();
        return new UserDTO(
            user.getId(),
            user.getName(),
            user.getAge(),
            user.getCreatedAt());
    }

    public UserDTO save(CreateUserDTO createUserDTO) {
        User user = new User(
            createUserDTO.name(),
            createUserDTO.age()
        );

        User savedUser = userRepository.save(user);

        return new UserDTO(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getAge(),
            savedUser.getCreatedAt());
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
    
}
