package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * 插入方法接口
     *
     * @param book
     * @return
     */
    boolean save(Book book);

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 根据ID更新数据
     *
     * @param book
     * @return
     */
    boolean update(Book book);

    /**
     * 根据ID查询数据
     *
     * @param id
     * @return
     */
    Book getById(Integer id);

    /**
     * 查询所有
     *
     * @return
     */
    List<Book> getAll();

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Book> getByPage(int currentPage, int pageSize);

}
