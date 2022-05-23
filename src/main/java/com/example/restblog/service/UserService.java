package com.example.restblog.service;


import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Service allows us to register and inject UserService into any other class we want using Spring's IoC Container
@Service
public class UserService {

    //TODO: we refactored UsersController an PostsController to remove all the sausage-making of posts and users
    // userList and posts are our pretend database for now
    private List<User> userList = setUserList();
    private List<Post> posts = setPostsList();

    public List<User> getUsersList() {return userList;}
    public List<Post> getPostList() {return posts;}
}
