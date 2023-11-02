package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.BookInCart;
import com.project.online_book_store.app.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CartController {

    CartService cartService;

    @GetMapping("/cart")
    public String getCartPage(Model model){
        model.addAttribute("listBooksInCart", cartService.showBooks());
        model.addAttribute("countBooks", cartService.showBooks().size());
        Integer price = 0;
        List<BookInCart> list = cartService.showBooks();
        for(int i = 0; i < list.size(); i++) {
            price += list.get(i).getBook().getPrice();
        }
        model.addAttribute("priceTotal", price);
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
        return "redirect:/api/cart";
    }
}
