package com.alurageek.alurageek.services.roles;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alurageek.alurageek.models.Role;

@Service
public interface IRoleService {
    List<Role> findAll();
    Role findById(Long id);
    
}
