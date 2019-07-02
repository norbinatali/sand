package com.metrologist.sand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.OtsinkaV.dao.UserDao;
import ua.kiev.OtsinkaV.dao.UserRequestDao;
import ua.kiev.OtsinkaV.model.Role;
import ua.kiev.OtsinkaV.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Natalia on 10.04.2017.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRequestDao userRequestDao;
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);

        for (Role role : user.getRoles())
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),grantedAuthorities);
    }


}
