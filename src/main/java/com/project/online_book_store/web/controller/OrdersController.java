package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.BuyBook;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.repository.BuyBookRepository;
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


@Controller
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrdersController {

    BuyBookService buyBookService;
    BuyService buyService;
    CartService cartService;
    OrdersService ordersService;
    BuyBookRepository buyBookRepository;
    AccountRepository accountRepository;

    @ModelAttribute("mapListBooks")
    public Map<Integer, List<BuyBook>> mapListBooks(){
        return ordersService.createMapListOrders();
    }

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
