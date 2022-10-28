package com.example.hello.controller;

import com.example.hello.dao.UserDao;
import com.example.hello.domain.User;
import com.example.hello.domain.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/sign")
    public ResponseEntity<Integer> findById(@RequestBody UserDto userDto) {

        User user = new User(userDto.getId(), userDto.getName(), userDto.getPassword());

        return ResponseEntity
                .ok()
                .body(userDao.add(user));
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        userDao.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        userDao.deleteById(id);
        return ResponseEntity.status(204).build(); // No Contents
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        try {
            User user = userDao.findById(id);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
