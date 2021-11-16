package com.example.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBoottest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void test01() {
        IPage<Book> page = new Page<Book>(1, 5);
        IPage<Book> page1 = bookDao.selectPage(page, null);

    }
}
