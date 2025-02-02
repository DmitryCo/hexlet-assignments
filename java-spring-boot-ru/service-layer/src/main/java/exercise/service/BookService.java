package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        var books = bookRepository.findAll();
        var result = books.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO findBookById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO createBook(BookCreateDTO bookData) {
        var book = bookMapper.map(bookData);
        var authorID = bookData.getAuthorId();
        var author = authorRepository.findById(authorID)
                .orElseThrow(() -> new ConstraintViolationException(new HashSet<>()));
        book.setAuthor(author);
        bookRepository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO updateBook(BookUpdateDTO bookData, Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        bookMapper.update(bookData, book);
        bookRepository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
