package exercise.controller;

import exercise.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Comment show(@PathVariable("id") long id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found"));
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Comment comment) {
        commentRepository.save(comment);
    }

    @PutMapping(path = "/{id}")
    public Comment update(@PathVariable("id") long id, @RequestBody Comment data) {
        var comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found"));
        comment.setBody(data.getBody());
        commentRepository.save(comment);
        return comment;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") long id) {
        commentRepository.deleteById(id);
    }
}
// END
