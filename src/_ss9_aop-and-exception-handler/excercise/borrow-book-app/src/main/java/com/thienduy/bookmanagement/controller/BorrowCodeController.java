package com.thienduy.bookmanagement.controller;

import com.thienduy.bookmanagement.exception.NotFoundBorrowCode;
import com.thienduy.bookmanagement.model.BorrowingCode;
import com.thienduy.bookmanagement.service.IBooksService;
import com.thienduy.bookmanagement.service.IBorrowingCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BorrowCodeController {

    @Autowired
    IBooksService booksService;

    @Autowired
    IBorrowingCodeService borrowingCodeService;

    @GetMapping(value = "/book/borrow-list")
    public String showListObject(Model model) {
        List<BorrowingCode> borrowingCodeList = borrowingCodeService.findAll();
//        List<Book> bookList = booksService.findAll();
//        model.addAttribute("borrowingCode", new BorrowingCode());
        model.addAttribute("borrowingCodeList", borrowingCodeList);
        return "/borrow/list";
    }

//    @GetMapping("/{id}/return-form")
//    public String showReturnForm(Model model) {
//        return "/borrow/return";
//    }

    @GetMapping("/book/{code}/return-form")
    public String update(@PathVariable Integer code, Model model) throws NotFoundBorrowCode {
        model.addAttribute("borrowingCode", borrowingCodeService.findById(code));
        return "/borrow/return";
    }


    @PostMapping("/book/return-book")
    public String returnBook(@RequestParam Integer bookCode) throws NotFoundBorrowCode {
        BorrowingCode borrowingCode = borrowingCodeService.findById(bookCode);
        this.borrowingCodeService.delete(borrowingCode);
        this.booksService.giveBack(borrowingCode.getBooks());
        return "redirect:/book/borrow-list";
    }

    @ExceptionHandler(NotFoundBorrowCode.class)
    public String showErrorPage() {
        return "error2";
    }

}
