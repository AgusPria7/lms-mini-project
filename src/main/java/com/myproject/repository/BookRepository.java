
package com.myproject.repository;

import com.myproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book b WHERE b.genre = :genre", nativeQuery = true)
    List<Book> findBooksByGenre(@Param("genre") String genre);
}
