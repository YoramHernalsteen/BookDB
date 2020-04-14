package be.thomasmore.bookdb.repositories;

import be.thomasmore.bookdb.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Optional<Book> findByTitleLike(String title);

    @Query("select b from Book b where" +
            "(:min is null or b.pages>= :min) and"+
            "(:max is null or b.pages<= :max)and " +
            "(:bookTitle is null or  b.title like %:bookTitle%)"
    )
    public Iterable<Book>titleAndPages(@Param("min") Integer min, @Param("max") Integer max, @Param("bookTitle") String bookTitle);

    @Query("select b from Book b where b.genre.id = :genre")
    public Iterable<Book>findbyGenreName(@Param("genre") int genre);

    public Iterable<Book>findByPagesIsBetween(int min, int max);

}
