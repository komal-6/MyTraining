package com.graphql.graphqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.graphql.graphqldemo.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
