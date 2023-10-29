package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientNameController {

    public  GetNameService getNameService;

    @GetMapping(path = "/{name}")
    public Client getName(@PathVariable String name){
        return getNameService.getName(name);
    }
}