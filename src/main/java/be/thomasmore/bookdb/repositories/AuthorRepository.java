package be.thomasmore.bookdb.repositories;

import be.thomasmore.bookdb.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    public Optional<Author>findByNameLike(String authorName);
}

