package mak.sprigframework.spring6webapp.repositories;

import mak.sprigframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
