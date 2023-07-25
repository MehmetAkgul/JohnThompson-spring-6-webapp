package mak.sprigframework.spring6webapp.service;

import mak.sprigframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
