package com.myworkout.api.service;


import com.myworkout.api.dto.PatchUserDTO;
import com.myworkout.api.dto.UserDTO;
import com.myworkout.api.entity.User;
import com.myworkout.api.exception.BodyPartNotFoundException;
import com.myworkout.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    public User postUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User updateUserById(Long id, @Valid PatchUserDTO userDTO){
        User user = findUserById(id);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }
}
