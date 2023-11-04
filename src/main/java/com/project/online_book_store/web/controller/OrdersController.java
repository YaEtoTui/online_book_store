package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.repository.BuyBookRepository;
import com.project.online_book_store.app.service.BuyBookService;
import com.project.online_book_store.app.service.BuyService;
import com.project.online_book_store.app.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrdersController {

    BuyBookService buyBookService;
    BuyService buyService;
    CartService cartService;
    BuyBookRepository buyBookRepository;

    @GetMapping("/orders")
    public String getOrdersPage(Model model) {
        model.addAttribute("buyId", buyService.searchBuyByClient().getId());
        model.addAttribute("listBuyBook", buyBookService.getListBuyBooks());
        model.addAttribute("countBooks", cartService.showBooks().size());
        return "orders";
    }

    @PostMapping("/orders/order/{id}")
    public String getOrderDescPage(@PathVariable Long id, Model model) {
        model.addAttribute("listBuy", buyBookRepository.findAllByBuy_Id(id));
        return "order";
    }
}
