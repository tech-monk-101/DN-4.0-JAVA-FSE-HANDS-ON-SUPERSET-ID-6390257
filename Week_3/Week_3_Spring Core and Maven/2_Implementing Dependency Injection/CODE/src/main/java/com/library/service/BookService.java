package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository br;

    public void setBookRepository(BookRepository br) {
        this.br = br;
    }

    public void addBook(String title) {
        br.insertBook(title);
    }
}
