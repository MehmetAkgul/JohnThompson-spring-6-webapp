package mak.sprigframework.spring6webapp.bootstrap;


import mak.sprigframework.spring6webapp.domain.Author;
import mak.sprigframework.spring6webapp.domain.Book;
import mak.sprigframework.spring6webapp.domain.Publisher;
import mak.sprigframework.spring6webapp.repositories.AuthorRepository;
import mak.sprigframework.spring6webapp.repositories.BookRepository;
import mak.sprigframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        Author ericSaved = authorRepository.save(eric);


        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
        Book dddSaved = bookRepository.save(ddd);


        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        Author rodSaved = authorRepository.save(rod);


        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("547547547");
        Book noEJBSaved = bookRepository.save(noEJB);


        // bunlar hashset oldugundan setbook yapilamiyor
        // bu yuzden collectiona add olarak ekleniyor
        ericSaved.getBooks().add(dddSaved);
        dddSaved.getAuthors().add(ericSaved);

        rodSaved.getBooks().add(noEJBSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher isler = new Publisher();
        isler.setPublisherName("Isler");
        isler.setAddress("Ankara");
        isler.setCity("Anakra");
        isler.setZip(06006);

        Publisher islerSaved = publisherRepository.save(isler);

        dddSaved.setPublisher(islerSaved);
        noEJBSaved.setPublisher(islerSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);


        System.out.println("in Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
