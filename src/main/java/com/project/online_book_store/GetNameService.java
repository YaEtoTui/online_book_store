package com.project.online_book_store;


import com.project.online_book_store.app.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetNameService {

    @Autowired
    private ClientNameGetRepository getNameRepository;

    public Client getName(String name) {
        return getNameRepository.findById(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}


