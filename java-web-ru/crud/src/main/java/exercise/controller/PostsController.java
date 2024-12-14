package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;
import exercise.model.Post;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        Integer page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int firstIndex = (page - 1) * 5;
        int secondIndex = Math.min(posts.size(), (firstIndex + 5));
        List<Post> sliceOfPosts = posts.subList(firstIndex, secondIndex);
        PostsPage postsPage = new PostsPage(sliceOfPosts, page, posts.size());
        ctx.render("posts/index.jte", model("page", postsPage));
    }
    // END
}
