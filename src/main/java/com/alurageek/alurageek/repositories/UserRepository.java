package com.alurageek.alurageek.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alurageek.alurageek.models.User;

public interface UserRepository extends CrudRepository<User,Long> {    
}
