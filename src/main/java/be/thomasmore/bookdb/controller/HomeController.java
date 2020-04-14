package be.thomasmore.bookdb.controller;

import be.thomasmore.bookdb.model.Author;
import be.thomasmore.bookdb.model.Book;
import be.thomasmore.bookdb.repositories.AuthorRepository;
import be.thomasmore.bookdb.repositories.BookRepository;
import be.thomasmore.bookdb.repositories.GenreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;
    private String header = "So many books, so little time.";

    @GetMapping({"/", "/books", "/books/{genre}"})
    public String home(@PathVariable(required = false) String genre,
                       Model model) {
        model.addAttribute("header", header);
        model.addAttribute("genres", genreRepository.findAll());
        int genreid = 0;
        if (genre != null) {
            genreid = Integer.parseInt(genre);
        }
        if (genreid == 0) {
            model.addAttribute("book", bookRepository.findAll());
        } else if (genreid != 0) {
            model.addAttribute("book", bookRepository.findbyGenreName(genreid));
        }
        return "home";
    }

    @GetMapping({"/author", "/author/{id}"})
    public String author(@PathVariable(required = false) int id, Model model) {
        model.addAttribute("header", header);
        long nrOfAuthors = authorRepository.count();
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        Author authorFromDb = null;
        if (optionalAuthor.isPresent()) {
            authorFromDb = optionalAuthor.get();
        }
        model.addAttribute("author", authorFromDb);
        model.addAttribute("idOfPrevAuthor", id > 1 ? id - 1 : nrOfAuthors);
        model.addAttribute("idOfNextAuthor", id < nrOfAuthors ? id + 1 : 1);

        return "author";
    }

    @GetMapping({"/book", "/book/{id}"})
    public String book(@PathVariable(required = false) int id, Model model) {
        model.addAttribute("header", header);
        long nrOfBooks = bookRepository.count();
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book bookFromDb = null;
        if (optionalBook.isPresent()) {
            bookFromDb = optionalBook.get();
        }
        model.addAttribute("book", bookFromDb);
        model.addAttribute("idOfPrevBook", id > 1 ? id - 1 : nrOfBooks);
        model.addAttribute("idOfNextBook", id < nrOfBooks ? id + 1 : 1);

        return "book";
    }

    @GetMapping({"/advancedSearch", "/advancedSearch/{size}"})
    public String advancedSearch(@PathVariable(required = false) String size,
                                 @RequestParam(required = false) Integer min,
                                 @RequestParam(required = false) Integer max,
                                 @RequestParam(required = false) String title,
                                 Model model) {
        if (min == null && max == null && size != null) {
            if (size.equals("150")) {
                min = 0;
                max = 150;
            } else if (size.equals("300")) {
                min = 0;
                max = 300;
            } else if (size.equals("450")) {
                min = 0;
                max = 450;
            } else if (size.equals("600")) {
                min = 0;
                max = 600;
            } else if (size.equals("750")) {
                min = 0;
                max = 750;
            } else if (size.equals("all")) {
                min = 0;
                max = 5000;
            }
        }
        logger.info(String.format("interpreted: min = %d, max=%d, bookTitle=%s", min, max, title));
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("title", title);
        model.addAttribute("header", header);
        model.addAttribute("book", bookRepository.titleAndPages(min, max, title));
        return "advancedSearch";
    }

    @GetMapping("/authors")
    public String authors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("header", header);
        return "authors";
    }


}
