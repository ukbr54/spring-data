package com.example.persistenceproject;

import com.example.persistenceproject.entity.Book;
import com.example.persistenceproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {"spring.h2.console.enabled=true","spring.h2.console.path=/h2-console"}
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuditingTest {

    private @Autowired BookRepository bookRepository;

    @Test
    public void testAuditing(){
        Book book = new Book();
        book.setIsbn("001-SDJ");
        book.setTitle("Core");
        Book save = bookRepository.save(book);

        book.setTitle("Core, 2nd Edition");
        Book save1 = bookRepository.save(book);

        System.out.println(bookRepository.findById(1l));
    }
}
