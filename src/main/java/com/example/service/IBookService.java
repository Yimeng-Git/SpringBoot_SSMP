package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

public interface IBookService extends IService<Book> {
    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Book> getByPage(int currentPage, int pageSize);

}
