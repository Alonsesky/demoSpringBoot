package com.example.demo.service.impl;


import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.persistence.entity.UserAccount;
import com.example.demo.persistence.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userRepository;

    @Override
    public List<UserAccount> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserAccount> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserAccount> findAllByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    @Override
    public UserAccount findOneByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new ObjectNotFoundException("[user:" + username + "]"));
    }

    @Override
    public UserAccount saveOne(UserAccount userAccount) {
        return userRepository.save(userAccount);
    }

    @Override
    public UserAccount updateOneByUsername(String username, UserAccount userAccount) {
        UserAccount oldUser = this.findOneByUsername(username);
        oldUser.setName(userAccount.getName());
        oldUser.setPassword(userAccount.getPassword());
        return userRepository.save(oldUser);
    }

    @Override
    public void deleteByUsername(String username) {
        UserAccount user = this.findOneByUsername(username);
        userRepository.delete(user);
    }
}
