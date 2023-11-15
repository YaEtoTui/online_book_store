package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.BookInCart;
import com.project.online_book_store.app.domain.entity.Cart;
import com.project.online_book_store.app.domain.entity.Client;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.repository.CartRepository;
import com.project.online_book_store.app.repository.ClientRepository;
import com.project.online_book_store.app.service.CartService;
import com.project.online_book_store.app.service.OrdersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CartController {

    CartService cartService;
    OrdersService ordersService;
    AccountRepository accountRepository;

    @GetMapping("/cart")
    public String getCartPage(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findAccountByUsername(username);

        model.addAttribute("listBooksInCart", account.getClient().getCart().getBookInCartList());
        model.addAttribute("countBooks", account.getClient().getCart().getBookInCartList().size());
        Integer price = 0;
        List<BookInCart> list = cartService.showBooks();
        for(int i = 0; i < list.size(); i++) {
            price += list.get(i).getBook().getPrice();
        }
        model.addAttribute("priceTotal", price);

        model.addAttribute("cartId", account.getClient().getCart().getId());
        return "cart";
    }

    @PostMapping("/bookInCart/{bookId}")
    public String addBookInCart(@PathVariable Long bookId) {
        cartService.addBookInCart(bookId);
        System.out.println("Книга в корзине");
        return "redirect:/api/";
    }

    @PostMapping("/deleteBookInCart/{bookInCartId}")
    public String deleteBookInCart(@PathVariable Long bookInCartId) {
        System.out.println(bookInCartId);
        cartService.deleteBookInCart(bookInCartId);
        System.out.println("Книга удалена");
        return "redirect:/user/cart";
    }

    @PostMapping("/buy/createOrder/{cartId}")
    public String createOrder(@PathVariable Long cartId) {
        ordersService.createOrder(cartId);
        return "redirect:/user/cart";
    }
}
