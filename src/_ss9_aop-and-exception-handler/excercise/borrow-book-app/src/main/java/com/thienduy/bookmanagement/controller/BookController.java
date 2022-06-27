package com.thienduy.bookmanagement.controller;

import com.thienduy.bookmanagement.exception.BookRunOut;
import com.thienduy.bookmanagement.exception.NotFoundBorrowCode;
import com.thienduy.bookmanagement.model.Book;
import com.thienduy.bookmanagement.model.BorrowingCode;
import com.thienduy.bookmanagement.service.IBooksService;
import com.thienduy.bookmanagement.service.IBorrowingCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    IBooksService booksService;

    @Autowired
    IBorrowingCodeService borrowingCodeService;

    @GetMapping
    public String showListObject(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("author").ascending();
        Page<Book> bookList = booksService.findAllBookPage(PageRequest.of(page, 3, sort));
//        List<Book> bookList = booksService.findAll();
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookList);
        return "/book/book-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "/book/create";
    }

    @PostMapping("/save")
    public String save(@Validated Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/book/create";
        }
        booksService.save(book);
        redirectAttributes.addFlashAttribute("success", "Create book successfully!");
        return "redirect:/book";
    }


    @GetMapping("/goborrow")
    public String goBorrowForm(Model model, @RequestParam Integer id) {
        model.addAttribute("book", this.booksService.findById(id));
        return "/borrow/borrow";
    }

//    @GetMapping("/borrow-date")
//    public String showBorrowDate(Model model){
//        model.addAttribute("borrowingCode", new BorrowingCode());
//        return "/borrow/choose-borrow-date";
//    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute Book books) throws BookRunOut {
        this.booksService.borrow(books);
        BorrowingCode borrowingCode = new BorrowingCode();
        borrowingCode.setBooks(books);
        this.borrowingCodeService.saveBookCode(borrowingCode);
        return "redirect:/book";
    }

    @GetMapping("/return-form")
    public String showReturnForm() {
        return "/borrow/return";
    }


    @PostMapping("/return")
    public String returnBook(@RequestParam Integer bookCode) throws NotFoundBorrowCode {
        BorrowingCode borrowingCode = borrowingCodeService.findById(bookCode);
        this.borrowingCodeService.delete(borrowingCode);
        this.booksService.giveBack(borrowingCode.getBooks());
        return "redirect:/book";
    }

}
