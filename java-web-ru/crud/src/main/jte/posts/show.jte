@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <div class="mb-3">
        <a href="/posts">Return to all posts</a>
    </div>
    <div>
        <h2>${page.getPost().getName()}</h2>
        <p>${page.getPost().getBody()}</p>

    </div>
`
)