package com.alurageek.alurageek.services.users;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alurageek.alurageek.models.Role;
import com.alurageek.alurageek.models.User;
import com.alurageek.alurageek.repositories.ICrudRepositoryUser;
import com.alurageek.alurageek.repositories.IRoleRepository;



@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private ICrudRepositoryUser userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    
    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByIdUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        //we assign the role to the user
        
        List<Role> roles = user.getRoles();
        List<Role> rolesPersist = new ArrayList<>();
        for(Role role: roles){
            rolesPersist.add(roleRepository.findById(role.getId()).get());
        }
        user.setRoles(rolesPersist);

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user, Long id) {

        User userPersist = findByIdUser(id);

        userPersist.setName(user.getName());
        userPersist.setEmail(user.getEmail());
        userPersist.setLastName(user.getLastName());
        userPersist.setPassword(userPersist.getPassword());
        userPersist.setRoles(user.getRoles());
  
        // llamo al mismo metodo de esta clase 
        return saveUser(userPersist);
    }

    @Override
    @Transactional
    public void deleteByIdUser(Long id) {
        userRepository.deleteById(id);   
    }  
}
