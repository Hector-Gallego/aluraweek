package com.alurageek.alurageek.services.roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alurageek.alurageek.models.Role;
import com.alurageek.alurageek.repositories.RoleRepository;


@Service
public class RoleServiceImpl implements IRoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Role> findAll() {

        return (List<Role>)roleRepository.findAll();

    }

    @Override
    @Transactional(readOnly=true)
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    
    
}
