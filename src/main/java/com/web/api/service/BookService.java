package com.web.api.service;

import com.web.api.dao.BookDao;
import com.web.api.model.Book;
import com.web.api.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by xingding on 2016/11/12.
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public List<Book> findByTitle(String title){
        return bookDao.findByTitle(title);
    }

    public int insertBook(Book book){
        return bookDao.insertBook(book);
    }

    public int updateBook(Book book){
        return bookDao.updateBook(book);
    }

    public int deleteBook(Long id){
        return bookDao.deleteBook(id);
    }

    public Book selectBookById(Long id){
        return bookDao.selectBookById(id);
    }


    public List<Category> findCategorys(){
        return bookDao.findCategorys();
    }
}
