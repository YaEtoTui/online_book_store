package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.BookInCart;
import com.project.online_book_store.app.service.AccountService;
import com.project.online_book_store.app.service.CartService;
import com.project.online_book_store.app.service.OrdersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/* Контроллер для перехода на страницу "Корзина"(это верхняя правая иконка). Здесь эндпоинты: удалить книгу, оформить заказ*/

@Controller
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CartController {

    CartService cartService;
    OrdersService ordersService;
    AccountService accountService;

    @GetMapping("/cart")
    public String getCartPage(Model model){

        model.addAttribute("isAuthenticated", accountService.isAuthenticated());
        Account account = accountService.getAccount();

        model.addAttribute("listBooksInCart", account.getClient().getCart().getBookInCartList());
        model.addAttribute("countBooks", account.getClient().getCart().getBookInCartList().size());
        Integer price = 0;
        List<BookInCart> list = account.getClient().getCart().getBookInCartList();
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
        cartService.deleteBookInCart(bookInCartId);
        System.out.println(String.format("Книга удалена c id %s", bookInCartId));
        return "redirect:/user/cart";
    }

    @PostMapping("/buy/createOrder/{cartId}")
    public String createOrder(@PathVariable Long cartId) {
        ordersService.createOrder(cartId);
        return "redirect:/user/cart";
    }
}
