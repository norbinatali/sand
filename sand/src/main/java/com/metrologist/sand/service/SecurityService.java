package com.metrologist.sand.service;

/**
 * Created by Natalia on 10.04.2017.
 */
public interface SecurityService {


    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
