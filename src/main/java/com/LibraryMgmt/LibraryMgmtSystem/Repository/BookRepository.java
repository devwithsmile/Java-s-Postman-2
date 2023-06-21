package com.LibraryMgmt.LibraryMgmtSystem.Repository;

import org.springframework.stereotype.Repository;

import com.LibraryMgmt.LibraryMgmtSystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BookRepository extends JpaRepository<Book,Long > {

   
}
