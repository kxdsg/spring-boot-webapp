package com.web.api.dao;

import com.web.api.model.Book;
import com.web.api.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 * Created by xingding on 2016/11/12.
 */
@Mapper
public interface BookDao {

    @Select("select a.id, a.title, a.author, b.desc as category, a.description from book a left join category b on a.category = b.code")
    List<Book> findAll();

    @Select("select a.id, a.title, a.author, b.desc as category, a.description from book a left join category b on a.category = b.code " +
            "where a.title like concat('%', #{title}, '%')")
    List<Book> findByTitle(String title);

    @Insert("insert into book(title, author, category, description) " +
            "values (#{title},#{author},#{category}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertBook(Book book);

    @Update("update book set title = #{title}, author = #{author}, category = #{category}, description = #{description} where id = #{id}")
    int updateBook(Book book);

    @Delete("delete from book where id = #{id}")
    int deleteBook(Long id);

    @Select("select * from book where id = #{id}")
    Book selectBookById(Long id);

    @Select("select * from category")
    List<Category> findCategorys();

}
