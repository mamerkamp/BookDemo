package nl.miwgroningen.cohort4.mark.demo.controller;

import nl.miwgroningen.cohort4.mark.demo.model.Book;
import nl.miwgroningen.cohort4.mark.demo.repository.AuthorRepository;
import nl.miwgroningen.cohort4.mark.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: Mark Amerkamp (markamerkamp@gmail.com)
 *
 * Stuur de views voor Book aan.
 */

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping({"/", "/books"})
    protected String showBooks(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());
        return "bookOverview";
    }

    @GetMapping("/books/add")
    protected String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorRepository.findAll());
        return "bookForm";
    }

    @PostMapping("/books/add")
    protected String saveOrUpdateBook(@ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookForm";
        } else {
            bookRepository.save(book);
            return "redirect:/books";
        }
    }
}
