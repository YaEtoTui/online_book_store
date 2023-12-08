package com.project.online_book_store.app.service.factory;

import com.project.online_book_store.app.domain.entity.context.AccountContext;
import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestNewAccount;
import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestRegisterForm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/* Здесь мы создаем, переделываем объекты, нужные для дальнейшего использования */

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountFactory {
    PasswordEncoder passwordEncoder;

    //Переделываем объект из класса CreateRequestNewAccount в AccountContext
    public AccountContext createAccountContext(CreateRequestNewAccount requestNewAccount) {
        return new AccountContext(
                requestNewAccount.getUsername(),
                passwordEncoder.encode(requestNewAccount.getPassword())
        );
    }

    //Переделываем объект из класса CreateRequestRegisterForm в AccountContext
    public AccountContext createAccountContextRegisterForm(CreateRequestRegisterForm registerForm) {
        return new AccountContext(
                registerForm.getUsername(),
                passwordEncoder.encode(registerForm.getPassword())
        );
    }
}
