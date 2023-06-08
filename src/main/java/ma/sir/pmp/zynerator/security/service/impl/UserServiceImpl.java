package ma.sir.pmp.zynerator.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import  ma.sir.pmp.zynerator.security.bean.Role;
import ma.sir.pmp.zynerator.security.bean.User;
import ma.sir.pmp.zynerator.security.dao.UserDao;

import ma.sir.pmp.zynerator.security.service.facade.RoleService;
import ma.sir.pmp.zynerator.security.service.facade.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired @Lazy
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUsername(String username) {
        if (username == null)
        return null;
        return userDao.findByUsername(username);
    }

    @Override
    public User findByUsernameWithRoles(String username) {
        if (username == null)
        return null;
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public int deleteByUsername(String username) {
        return userDao.deleteByUsername(username);
    }

    @Override
    public User findById(Long id) {
        if (id == null)
        return null;
        return userDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User save(User user) {
    User foundedUserByUsername = findByUsername(user.getUsername());
    User foundedUserByEmail = userDao.findByEmail(user.getEmail());
    if (foundedUserByUsername != null || foundedUserByEmail != null) return null;
    else {
    /*if (user.getPassword() == null || user.getPassword().isEmpty()) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getUsername()));
    }
    else {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }*/
    user.setPassword(bCryptPasswordEncoder.encode("123"));
    user.setAccountNonExpired(true);
    user.setAccountNonLocked(true);
    user.setCredentialsNonExpired(true);
    user.setEnabled(true);
    user.setPasswordChanged(false);
    user.setCreatedAt(LocalDateTime.now());

    if (user.getRoles() != null) {
    Collection<Role> roles = new ArrayList<Role>();
            for (Role role : user.getRoles()) {
            roles.add(roleService.save(role));
            }
            user.setRoles(roles);
            }
            User mySaved = userDao.save(user);
            return mySaved;
            }
            }



    @Override
    public User update(User user) {
        User foundedUser = findById(user.getId());
        if (foundedUser == null) return null;
        else {
            foundedUser.setEmail(user.getEmail());
            foundedUser.setUsername(user.getUsername());
            foundedUser.setPrenom(user.getPrenom());
            foundedUser.setNom(user.getNom());
            foundedUser.setEnabled(user.isEnabled());
            foundedUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
            foundedUser.setAccountNonLocked(user.isAccountNonLocked());
            foundedUser.setAccountNonExpired(user.isAccountNonExpired());
            foundedUser.setAuthorities(new ArrayList<>());
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : user.getRoles()) {
            	roles.add(roleService.save(role));
            }
            foundedUser.setRoles(roles);
            return userDao.save(foundedUser);
        }
    }

    @Override
    @Transactional
    public int delete(Long id) {
        User foundedUser = findById(id);
        if (foundedUser == null) return -1;
        userDao.delete(foundedUser);
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsernameWithRoles(username);
    }
}
