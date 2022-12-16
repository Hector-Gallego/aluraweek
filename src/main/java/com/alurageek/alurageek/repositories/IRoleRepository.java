package com.alurageek.alurageek.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alurageek.alurageek.models.Role;

public interface IRoleRepository extends CrudRepository<Role, Long> {  
}
