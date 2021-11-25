package com.library.boks.service;


import com.library.boks.entity.Book;
import com.library.boks.exceptions.NotFoundBookException;
import com.library.boks.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookDtoListByPrefix(String prefix) {
        return bookRepository.findByTitleLike(prefix);
    }
    public Book getBookById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundBookException("Книга с таким айди не найдена"));
    }
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }
}
