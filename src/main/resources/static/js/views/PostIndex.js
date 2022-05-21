import createView from "../createView";

const BASE_URL = "http://localhost:8080/api/posts";
let requestMethod = "POST";
let postId = "";

export default function PostIndex(props) {
    //language=HTML
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--        code below is for adding new elements such as the post's content-->
            <div id="posts-container">
                ${props.posts.map(post =>
        //TODO: make sure you wrap each post in its own container with a css id attribute linked to the post id
                    `<div class="post-container" id="post-container">
                        <h3 id="title - ${post.id}">${post.title}</h3>
                        <p id="content - ${post.content}"</p>
                        <p id="author">${post.user.username}</p>
                        <button type="enter" class="edit-button" data-id="${post.id}">Edit Content</button>
                        <button type="enter" class="delete-button" data-id="${post.id}">Delete</button>
                        </div>
                    `).join('')}   
                    </div>
                    <div id="add-post-form">
                        <div type="text" id="new-post-title" class="new-post-title" placeholder="Post Title Here">
                    </div>
                    <br>
                    <div>
                        <textarea class="form" rows="4" id="add-post-content" placeholder="Add Content Here"></textarea>
                    </div>
                    <br>
                    <div>
                        <button type="submit" class="btn btn-primary" id="submit-btn">Submit</button>
                    </div>
            </div>
        </main>
    `;
}