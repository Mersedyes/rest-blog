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

    export function PostsEvent() {
        createSubmitPostListener();
        createEditPostListener();
        createDeletePostListener();
    }

    function createSubmitPostListener() {
        $(document).on('click', '#submit-btn', function (e) {
            e.preventDefault();
            const newPost = {
                title: $("#add-post-title").val(),
                content: $("#add-post-content").val()
            };

            const request = {
                method: requestMethod,
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newPost)
            }

            let requestURL = "";

            const fakeUsername = 'Bob'; //TODO: replace once I implement login
            if (fakeUsername) {
                requestURL = `{$BASE_URL}/${fakeUsername}`;
            } else {
                requestURL = `{$BASE_URL}`;
            }

            //TODO: if the post was successful, no need to parse out the response...just have a catch and finally block
            fetch(requestURL, request)
                .catch(error => {
                    console.log(error);
                })
                .finally(() => {
                    postId = "";
                    requestMethod = "POST";
                    createView("/posts")
                })
        })
    }

    function createEditPostListener() {
        $(document).on("click", '.edit-button', function (e) {
            e.preventDefault();
            postId = $(this).data("id");

            const postTitle = $(`#title-${postId}`).text();
            const postContent = $(`#content-${postId}`).text();

            const request = {
                method: "PUT",
                body: JSON.stringify({
                    id: postId,
                    title: postTitle,
                    postContent: postContent
                })
            };

            fetch(`${BASE_URL}/${postId}`, request)
                //TODO: no need to reload the page if successful
                .then(response => {
                    return response.json();
                })
                .catch(error => console.log(error));
        })
    }

    function createDeletePostListener() {
        $(document).on('click', '.delete-button', function (e) {
            e.preventDefault();

            const id = $(this).data("id");

            const request = {
                method: "DELETE"
            };

            fetch(`${BASE_URL}/${id}`, request)
                .then(response => {
                    console.log(response.status);
                    //TODO: once we get a successful response, remove the post element from the DOM
                    $(`#post-${id}`).remove();
                })
                .catch(error => {
                    console.log(error);
                });
        })
    }

}