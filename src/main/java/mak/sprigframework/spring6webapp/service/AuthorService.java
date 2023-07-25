package mak.sprigframework.spring6webapp.service;

import mak.sprigframework.spring6webapp.domain.Author;
 
public interface AuthorService {

    Iterable<Author> findAll();
}
