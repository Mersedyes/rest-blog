package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    // TODO: see UsersController for the "why" of this
    private final UserService userService;

    public PostController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<Post> getAll() {
        return userService.getPostList();
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {

        // TODO: refactor this all out of here
        for (Post post : userService.getPostList()) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
        return null;
    }

    @PostMapping
    public void createPost(@RequestBody Post postToAdd) {
        // TODO: If you want to associate the user to the post here, be sure to include a user object property on the post from the client side
        System.out.println(postToAdd);
    }

    @PostMapping("{username}")
    public void createByUsername(@PathVariable String username, @RequestBody Post newPost){
        // Nice and clean, huh?
        userService.addPost(newPost, username);
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        // TODO: refactor this ALL out of here to a public method in UserService
        userService.updatePost(id, updatedPost);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        // TODO: add a public method in UserService to actually delete a Post by ID. Invoke that method here
        userService.deletePostById(id);
    }

}

//
//    //
//    //this method will return an ArrayList of Post objects
//    List<Post> posts = new ArrayList<>();
//
//    //annotated this method
//    @GetMapping
//    //make a list of Post objects and add 2-3 posts to that list with beli values
//    public List<Post> getAll(){
//        posts.add(new Post(1L, "Cool title", "Cool content"));
//        posts.add(new Post(2L, "Fake title", "Fake content"));
//        posts.add(new Post(3L, "Not from Db", "Fake data"));
//        //return the list to fulfill the return expectation of the method
//        return posts;
//    }
//
//    //this method will return a single Post object
//    @GetMapping("{id}")
//    //getByID() has one parameter mapped by @PathVariable to the route's {id}
//    //the parameter is of type Long and is named id
//    public Post getById(@PathVariable Long id){
//        //create and return a new Post object with all fields populated
//        for(Post post : getAll()){
//            if(Objects.equals(post.getId(), id)){
//                return post;
//            }
//        }
//        return new Post();
//    }
//
//    //create posts - Make createPost() & use @PostMapping to allow POST requests/responses to be handled in PostController
//    @PostMapping
//    //This method will be private, return void and accept a Post object
//    public void createPost(@RequestBody Post post){
//        System.out.println(post);
//    }
//    //update posts
//    //Make updatePost() and use @PutMapping to allow PUT requests/responses to be handled in PostController
//    @PutMapping("{id}")
//    //will help get the POST from the db by ID, update it in the code, then save it back to the database
//    public void updatePost(@PathVariable Long id, @RequestBody Post post){
//        System.out.println(post);
//    }
//    //delete posts
//    @DeleteMapping("{id}")
//    public void deletePost(@PathVariable Long id, @RequestBody Post post){
//        System.out.println(post);
//    }
//}
