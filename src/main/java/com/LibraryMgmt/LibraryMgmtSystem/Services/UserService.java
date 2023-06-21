package com.LibraryMgmt.LibraryMgmtSystem.Services;

import com.LibraryMgmt.LibraryMgmtSystem.models.Book;
import com.LibraryMgmt.LibraryMgmtSystem.models.User;
import com.LibraryMgmt.LibraryMgmtSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
		
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(@PathVariable Long id, @Validated @RequestBody User updatinguser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        user.setId(updatinguser.getId());
        user.setName(updatinguser.getName());
        user.setUsername(updatinguser.getUsername());
        user.setPassword(updatinguser.getPassword());
        userRepository.save(user);

        return user;
    }

    public void deleteUser1(Long id) {
        userRepository.deleteById(id);
    }

    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
