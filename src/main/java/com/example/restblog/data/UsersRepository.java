package com.example.restblog.data;

public interface UsersRepository {
    //TODO: NEED USERSREPOSITORY
    public interface UsersRepository extends JpaRepository<User, Long>{

        //TODO ADD THIS METHOD TO USERSREPOSITORY
        User findByUsername(String username);
    }
}
