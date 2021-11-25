package com.library.boks.controller;

import com.library.boks.entity.Book;
import com.library.boks.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class LibraryController {
    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ModelAndView getBooksOfLibrary(@RequestParam(name = "titlePrefix", required = false) String titlePrefix){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("library");
        String prefix = titlePrefix == null ? "%" : titlePrefix + "%";
        modelAndView.addObject("books", bookService.getBookDtoListByPrefix(prefix));
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView getNewBookForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("form_book");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getBookForm(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("form_book");
        modelAndView.addObject("book", bookService.getBookById(id));
        return modelAndView;
    }

    @PostMapping("/save")
    public String submitCourseForm(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form_book";
        }
        bookService.save(book);
        return "redirect:/books";
    }
}
