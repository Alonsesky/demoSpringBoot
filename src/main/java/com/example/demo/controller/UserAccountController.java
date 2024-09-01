package com.example.demo.controller;

import com.example.demo.persistence.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.service.impl.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<UserAccount> users = userAccountService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> findOneByUsername(@PathVariable String username){
        UserAccount user = userAccountService.findOneByUsername(username);
        return ResponseEntity.ok(user);
    }

    
}
