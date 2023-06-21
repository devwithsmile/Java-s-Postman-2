package com.LibraryMgmt.LibraryMgmtSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LibraryMgmt.LibraryMgmtSystem.Services.LibrarianService;
import com.LibraryMgmt.LibraryMgmtSystem.models.Librarian;

import java.util.List;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {

    private final LibrarianService librarianService;

    @Autowired
    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping
    public ResponseEntity<List<Librarian>> getAllLibrarians() {
        List<Librarian> librarians = librarianService.getAllLibrarians();
        return new ResponseEntity<>(librarians, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Librarian> getLibrarianById(@PathVariable("id") Long id) {
        Librarian librarian = librarianService.getLibrarianById(id);
        return new ResponseEntity<>(librarian, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Librarian> createLibrarian(@RequestBody Librarian librarian) {
        Librarian createdLibrarian = librarianService.createLibrarian(librarian);
        return new ResponseEntity<>(createdLibrarian, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Librarian> updateLibrarian(@PathVariable("id") Long id, @RequestBody Librarian updatedLibrarian) {
        Librarian librarian = librarianService.updateLibrarian(id, updatedLibrarian);
        return new ResponseEntity<>(librarian, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable("id") Long id) {
        librarianService.deleteLibrarian(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
