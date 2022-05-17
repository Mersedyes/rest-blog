package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Inform Spring how to direct requests to PostController, as well as what type of data is accepted
@RestController
//Inform Spring to send requests on /api/posts to this controller and also to accept application/json in requests
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    //this method will return an ArrayList of Post objects
    List<Post> posts = new ArrayList<>();

    //annotated this method
    @GetMapping
    //make a list of Post objects and add 2-3 posts to that list with belivable values
    public List<Post> getAll(){
        posts.add(new Post(1L, "Cool title", "Cool content"));
        posts.add(new Post(2L, "Fake title", "Fake content"));
        posts.add(new Post(3L, "Not from Db", "Fake data"));
        //return the list to fulfill the return expectation of the method
        return posts;
    }

    //this method will return a single Post object
    @GetMapping("{id}")
    //getByID() has one parameter mapped by @PathVariable to the route's {id}
    //the parameter is of type Long and is named id
    public Post getById(@PathVariable Long id){
        //create and return a new Post object with all fields populated
        for(Post post : getAll()){
            if(Objects.equals(post.getId(), id)){
                return post;
            }
        }
        return new Post();
    }

    //create posts - Make createPost() & use @PostMapping to allow POST requests/responses to be handled in PostController
    @PostMapping
    //This method will be private, return void and accept a Post object
    public void createPost(@RequestBody Post post){
        System.out.println(post);
    }
    //update posts
    //Make updatePost() and use @PutMapping to allow PUT requests/responses to be handled in PostController
    @PutMapping("{id}")
    //will help get the POST from the db by ID, update it in the code, then save it back to the database
    public void updatePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println(post);
    }
    //delete posts
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id, @RequestBody Post post){
        System.out.println(post);
    }
}
