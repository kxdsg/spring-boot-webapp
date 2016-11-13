package com.web.api.controller;

import com.web.api.model.Book;
import com.web.api.model.Category;
import com.web.api.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 页面跳转测试
 * Created by xingding on 2016/8/17.
 */
@Controller
public class BookController {

    public static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    /**
     * 进入列表页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String booklist(ModelMap map){
        List books = bookService.findAll();
        map.put("books",books);
        return "book/list";
    }

    /**
     * 查询
     * @param title
     * @param map
     * @return
     */
    @RequestMapping(value="/search", method = RequestMethod.GET)
    public String search(@RequestParam String title,  ModelMap map){
        List books = bookService.findByTitle(title);
        map.put("books",books);
        return "book/list";
    }

    /**
     * 进入新增页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(ModelMap map){
        List<Category> categorys = bookService.findCategorys();
        map.put("categorys", categorys);
        return "book/add";
    }

    /**
     * 新增
     * @param book
     * @param map
     * @return
     */
    @RequestMapping(value="/addbook", method = RequestMethod.POST)
    public String add(Book book, ModelMap map){
        bookService.insertBook(book);
        return "redirect:/list"; //跳转到/list，获取书单
    }

    /**
     * 进入编辑页面
     * @param bookid
     * @param map
     * @return
     */
    @RequestMapping(value = "/edit")
    public String edit(@RequestParam String bookid, ModelMap map){
        Long id = Long.parseLong(bookid);
        Book book = bookService.selectBookById(id);
        List<Category> categorys = bookService.findCategorys();
        map.put("categorys", categorys);
        map.put("book", book);
        return "book/edit";
    }

    /**
     * 更新
     * @param book
     * @param map
     * @return
     */
    @RequestMapping(value="/updatebook", method = RequestMethod.POST)
    public String update(Book book, ModelMap map){
        bookService.updateBook(book);
        return "redirect:/list"; //跳转到/list，获取书单
    }

    /**
     * 删除
     * @param bookid
     * @return
     */
    @RequestMapping(value="/delete")
    public String delete(@RequestParam String bookid){
        Long id = Long.parseLong(bookid);
        bookService.deleteBook(id);
        return "redirect:/list";
    }


}
