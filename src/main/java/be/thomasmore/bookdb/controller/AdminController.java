package be.thomasmore.bookdb.controller;

import be.thomasmore.bookdb.model.Author;
import be.thomasmore.bookdb.model.Book;
import be.thomasmore.bookdb.model.Genre;
import be.thomasmore.bookdb.repositories.AuthorRepository;
import be.thomasmore.bookdb.repositories.BookRepository;
import be.thomasmore.bookdb.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/create-book")
    public String createParty(Model model){
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        return "admin/create-book";
    }
    @PostMapping({"/create-book"})
    public String createBookPost(@RequestParam String bookTitle,
                                 @RequestParam(required = false)String bookIsbn,
                                 @RequestParam String bookAuthor,
                                 @RequestParam String bookGenre,
                                  Model model) {
        Optional<Book> bookOptional = bookRepository.findByTitleLike(bookTitle);
        Optional<Genre> genreOptional =genreRepository.findByGenreNameLike(bookGenre);
        Optional<Author> authorOptional = authorRepository.findByNameLike(bookAuthor);
        if(!bookOptional.isPresent()){
            if(bookTitle!= null && bookAuthor!= null && bookGenre!= null ){
                Book book = new Book();
                book.setTitle(bookTitle);
                if(authorOptional.isPresent()){
                    book.setAuthor(authorOptional.get());
                }
                if (genreOptional.isPresent()) {
                    book.setGenre(genreOptional.get());
                }
                book.setIsbn(bookIsbn);
                bookRepository.save(book);
            }
        }
        return "redirect:/books";
    }

    @GetMapping("/edit-book/{bookID}")
    public String editBook(@PathVariable(required = false) int bookID, Model model){
        Optional<Book> bookOptional = bookRepository.findById(bookID);
        Book bookFromDb = null;
        if(bookOptional.isPresent()){
            bookFromDb = bookOptional.get();
        }
        model.addAttribute("book", bookFromDb);
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        for(Genre g: genreRepository.findAll()){
            if(g.getGenreName().equals(bookFromDb.getGenre().getGenreName())){
                model.addAttribute("selectedGenre", g);
            }

        }
        for (Author a: authorRepository.findAll()){
            if(a.getName().equals(bookFromDb.getAuthor().getName())){
                model.addAttribute("selectedAuthor", a);
            }
        }
        return "admin/edit-book";
    }
    @PostMapping("/edit-book/{bookID}")
    public String postEditBook(@PathVariable(required = false) int bookID,
                               @RequestParam String bookTitle,
                               @RequestParam String bookIsbn,
                               @RequestParam String bookAuthor,
                               @RequestParam String bookGenre,
                               @RequestParam int bookPages,
                               @RequestParam String bookRead){

        Optional<Book> bookOptional = bookRepository.findById(bookID);
        Optional<Genre> genreOptional = genreRepository.findByGenreNameLike(bookGenre);
        Optional<Author> authorOptional = authorRepository.findByNameLike(bookAuthor);
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            book.setTitle(bookTitle);
            book.setIsbn(bookIsbn);
            if(genreOptional.isPresent()){
                book.setGenre(genreOptional.get());
            }
            if(authorOptional.isPresent()){
                book.setAuthor(authorOptional.get());
            }

            book.setReadFromString(bookRead);
            book.setPages(bookPages);
            bookRepository.save(book);
        }
        return "redirect:/book/"+bookID;
    }




}
