package mak.sprigframework.spring6webapp.repositories;

import mak.sprigframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
