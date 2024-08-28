package com.example.demo.service;

import com.example.demo.persistence.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    List<UserAccount> findAll();

    Optional<UserAccount> findOneById(Long id);

    List<UserAccount> findAllByName(String name);

    UserAccount findOneByUsername(String username);

    UserAccount saveOne(UserAccount userAccount);

    UserAccount updateOneByUsername(String username, UserAccount userAccount);

    void deleteByUsername(String username);
}
