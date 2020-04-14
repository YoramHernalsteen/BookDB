package be.thomasmore.bookdb.repositories;
import be.thomasmore.bookdb.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    public Optional<Genre>findByGenreNameLike(String genreName);
}
