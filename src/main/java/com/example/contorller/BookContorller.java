package com.example.contorller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.service.IBookService;
import com.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookContorller {

    @Autowired
    private IBookService bookService;

    @PostMapping
    public R save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        boolean flag = bookService.removeById(id);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        boolean flag = bookService.updateBy(book);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-");
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    /*  @GetMapping("/fandone")
      public R getById(Integer id) {
          return new R(true, bookService.getById(id));
      }
  */
    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Book book) {
        System.out.println("book====>" + book);

        IPage<Book> page = bookService.getByPage(currentPage, pageSize, book);
        //当当前页数大于总页数时，让当前页数为最后一页
        if (currentPage > page.getPages()) {
            page = bookService.getByPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
