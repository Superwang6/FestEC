package com.yuan.fest.test;

import com.yuan.fest.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("pro")
public class TestMongodb {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test1() {
        Book book = new Book();
        book.setId(1);
        book.setName("老王有点帅");
        book.setAuthor("老王");
        mongoTemplate.insert(book);
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }

    @Test
    public void test2() {
        List<Book> bookList = new ArrayList<>();
        for (int i = 2; i < 50; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName("老王有点帅" + ":" + i);
            book.setAuthor("老王" + ":" + i);
            bookList.add(book);
        }
        mongoTemplate.insertAll(bookList);
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all.toString());
    }
}
