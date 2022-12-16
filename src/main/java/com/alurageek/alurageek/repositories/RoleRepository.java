package com.alurageek.alurageek.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alurageek.alurageek.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {  
}
