package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAllAuthors() {
        var authors = authorRepository.findAll();
        var result = authors.stream()
                .map(authorMapper::map)
                .toList();
        return result;
    }

    public AuthorDTO findAuthorById(Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }

    public AuthorDTO createAuthor(AuthorCreateDTO authorData) {
        var author = authorMapper.map(authorData);
        authorRepository.save(author);
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }

    public AuthorDTO updateAuthor(AuthorUpdateDTO authorData, Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        authorMapper.update(authorData, author);
        authorRepository.save(author);
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
