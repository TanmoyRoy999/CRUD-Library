package com.SpringBoot.CRUD.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.CRUD.Entities.Book;

public interface DaoInterface extends JpaRepository<Book, Long>{

}
