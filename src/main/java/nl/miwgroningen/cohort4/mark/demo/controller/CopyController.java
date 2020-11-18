package nl.miwgroningen.cohort4.mark.demo.controller;

import nl.miwgroningen.cohort4.mark.demo.model.Book;
import nl.miwgroningen.cohort4.mark.demo.model.Copy;
import nl.miwgroningen.cohort4.mark.demo.repository.BookRepository;
import nl.miwgroningen.cohort4.mark.demo.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Author: Mark Amerkamp (markamerkamp@gmail.com)
 * <p>
 * Beschrijving:
 */
@Controller
public class CopyController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CopyRepository copyRepository;

    @GetMapping("/copy/add/{bookId}")
    protected String addCopy(@PathVariable("bookId") Integer bookId) {
        //Optional omdat het niet zeker is dat er een boek te vinden is.
        Optional<Book> bookBoox = bookRepository.findById(bookId);
        if (bookBoox.isPresent()) {
          Copy copy = new Copy();
          copy.setBook(bookBoox.get());
          copyRepository.save(copy);
        }
        return "redirect:/books";
    }
    // Om een copy te removen.
//    @GetMapping("copy/remove/{bookId}")
//    protected String addCopy(@PathVariable("bookId") Integer bookId) {
//        Optional<Book> bookBoox = bookRepository.findById(bookId);
//        if (bookBoox.isPresent()) {
//            Copy copy = new Copy();
//            copy.setBook(bookBoox.get());
//            copyRepository.save(copy);
//        }
//        return "redirect:/books";
//    }
    @GetMapping("/copy/add/t/{bookTitle}")
    protected String addCopyByTitle(@PathVariable("bookTitle") String bookTitle) {
        //Optional omdat het niet zeker is dat er een boek te vinden is.
        Optional<Book> bookBoox = bookRepository.findByTitle(bookTitle);
        if (bookBoox.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(bookBoox.get());
            copyRepository.save(copy);
        }
        return "redirect:/books";
    }

}
