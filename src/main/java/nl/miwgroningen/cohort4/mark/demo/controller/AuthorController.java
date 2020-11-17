package nl.miwgroningen.cohort4.mark.demo.controller;

import nl.miwgroningen.cohort4.mark.demo.model.Author;
import nl.miwgroningen.cohort4.mark.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: Mark Amerkamp (markamerkamp@gmail.com)
 * <p>
 * Beschrijving:
 */

@Controller
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/authors")
    protected String showAuthors(Model model) {

        model.addAttribute("allAuthors", authorRepository.findAll());
        model.addAttribute("author", new Author());
        return  "authorOverview";
    }

    @PostMapping("/author/add")
    protected String saveOrUpdateAuthor(@ModelAttribute("author") Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "authorOverview";
        } else {
            authorRepository.save(author);
            return "redirect:/authors";
        }
    }
}
