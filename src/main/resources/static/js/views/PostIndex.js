export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--        code below is for adding new elements such as the post's content-->
            <div id="posts-container">
                ${props.posts.map(post => `<h3>${post.title}</h3>`).join('')}   
            </div>
            <div id="new-post-form" class="new-post-form">
            <div type="text" id="new-post-title" class="new-post-title" placeholder="Post Title Here"
            </div>
            
            <br>
            
            <div>
            
</div>
        </main>
    `;
}