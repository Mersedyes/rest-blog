package com.example.restblog.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository {
    //TODO: NEED USERSREPOSITORY
    public interface UsersRepository extends JpaRepository<User, Long>{

        //TODO ADD THIS METHOD TO USERSREPOSITORY
        User findByUsername(String username);
    }
}
