package com.example.contorller;

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
        return new R(bookService.save(book));
    }

    @DeleteMapping
    public R delete(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
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
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return new R(true, bookService.getByPage(currentPage, pageSize));
    }
}
