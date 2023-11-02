package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.service.AdminService;
import com.project.online_book_store.app.service.factory.AdminFactory;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

    AdminFactory adminFactory;

    @Override
    public BookResponse uploadImage(Long imageId, MultipartFile image) {
        Path pathImage = adminFactory.addImageInFileSystem(image);
        return adminFactory.saveInDBPath(imageId, pathImage);
    }
}
