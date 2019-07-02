package com.metrologist.sand.service;

import com.metrologist.sand.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
