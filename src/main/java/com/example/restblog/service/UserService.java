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

    //We need to associate posts and users here
    public void addPost(Post newPost, String username){

        //get the User object who made the post
        User user = getUserByUsername(username);

        //associate the post with the user object
        user.getPosts().add(newPost);

        //add the post to the post list (the pseudo db)
        posts.add(newPost);
    }

    //Taken from UsersController
    public User getUserById(Long id){
        for(User user : userList){
            if(user.getId().equals(id)){
                return user;
            }
        } return null;
    }

    //Taken from UsersController
    public User getUserByUsername(String username){
        for(User user : userList){
            if (user.getUsername().equals(username)){
                return user;
            }
        } return null;
    }

    //Taken from UserController
    private List<User> setUserList(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "billyjean","billyjeanisnotmylover@gmail.com", "444444"));
        userList.add(new User(2L, "avamarie","avamaria@gmail.com", "12345"));
        return userList;
    }

    //Taken from PostsController
    private List<Post> setPostsList(){
        List<Post> postsList = new ArrayList<>();
        postsList.add(new Post(1L, "Awesome content", "Awesome content", userList.get(0)));
        postsList.add(new Post(2L, "Awesome content", "Awesome content", userList.get(1)));
        postsList.add(new Post(3L, "Awesome content", "Awesome content", userList.get(2)));
        return postsList;
    }
}
