package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var result = posts.stream()
                .map(this::toPostDTO)
                .toList();
        return result;
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var dtoPost = new PostDTO();
        dtoPost.setId(post.getId());
        dtoPost.setTitle(post.getTitle());
        dtoPost.setBody(post.getBody());
        var comments = commentRepository.findByPostId(id)
                .stream()
                .map(this::toCommentDTO)
                .toList();
        dtoPost.setComments(comments);
        return dtoPost;
    }

    private CommentDTO toCommentDTO(Comment comment) {
        var dtoComment = new CommentDTO();
        dtoComment.setId(comment.getId());
        dtoComment.setBody(comment.getBody());
        return dtoComment;
    }

    private PostDTO toPostDTO(Post post) {
        var dtoPost = new PostDTO();
        dtoPost.setId(post.getId());
        dtoPost.setTitle(post.getTitle());
        return dtoPost;
    }
}
// END
