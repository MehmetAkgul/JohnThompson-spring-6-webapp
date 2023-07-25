package mak.sprigframework.spring6webapp.controllers;

import mak.sprigframework.spring6webapp.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @RequestMapping("/authors")
    private String getBooks(Model model) {
        model.addAttribute("authors", authorService.findAll());

        return "authors";
    }

}
