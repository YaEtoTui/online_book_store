package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.BuyBook;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.repository.BuyBookRepository;
import com.project.online_book_store.app.repository.OrderRepository;
import com.project.online_book_store.app.service.BuyBookService;
import com.project.online_book_store.app.service.BuyService;
import com.project.online_book_store.app.service.CartService;
import com.project.online_book_store.app.service.OrdersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/* Контроллер для перехода на страницу "Заказы", где будут отображаться будущие заказы текущих пользователей*/

@Controller
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrdersController {

    BuyBookService buyBookService;
    CartService cartService;
    OrdersService ordersService;
    BuyBookRepository buyBookRepository;
    AccountRepository accountRepository;
    OrderRepository orderRepository;


    @GetMapping("/orders")
    public String getOrdersPage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findAccountByUsername(username);

        if (account != null) {
            model.addAttribute("isAuthenticated", false);
        } else {
            model.addAttribute("isAuthenticated", true);
        }

        model.addAttribute("mapListBooks", ordersService.createMapListOrders());
        model.addAttribute("listBuyBook", buyBookService.getListBuyBooks());
        model.addAttribute("countBooks", cartService.showBooks().size());
        return "orders";
    }

    @GetMapping("/orders/order/{id}")
    public String getOrderDescPage(@PathVariable Long id, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findAccountByUsername(username);

        if (account != null) {
            model.addAttribute("isAuthenticated", false);
        } else {
            model.addAttribute("isAuthenticated", true);
        }

        model.addAttribute("order", orderRepository.getReferenceById(id));
        model.addAttribute("listBuy", buyBookRepository.findAllByOrderId(id));
        return "order";
    }
}
