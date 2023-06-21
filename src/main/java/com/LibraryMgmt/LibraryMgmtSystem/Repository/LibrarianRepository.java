package com.LibraryMgmt.LibraryMgmtSystem.Repository;

import com.LibraryMgmt.LibraryMgmtSystem.models.Librarian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    
   
}


