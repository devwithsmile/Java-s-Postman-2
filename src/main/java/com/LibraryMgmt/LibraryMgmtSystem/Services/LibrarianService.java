package com.LibraryMgmt.LibraryMgmtSystem.Services;

import com.LibraryMgmt.LibraryMgmtSystem.Repository.LibrarianRepository;
import com.LibraryMgmt.LibraryMgmtSystem.models.Book;
import com.LibraryMgmt.LibraryMgmtSystem.models.Librarian;
import com.LibraryMgmt.LibraryMgmtSystem.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    @Autowired
    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public Librarian createLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    public Librarian getLibrarianById(Long id) {
        return librarianRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Librarian not found"));

    }

    public Librarian updateLibrarian1(Long id, Librarian updatedLibrarian) {
        Optional<Librarian> existingLibrarian = librarianRepository.findById(id);
        if (existingLibrarian.isPresent()) {
            Librarian librarian = existingLibrarian.get();
            librarian.setName(updatedLibrarian.getName());
            librarian.setUsername(updatedLibrarian.getUsername());
            librarian.setPassword(updatedLibrarian.getPassword());
            return librarianRepository.save(librarian);
        } else {
            throw new RuntimeException("Librarian not found");
        }
    }

   
    public  Librarian updateLibrarian(@PathVariable Long id, @Validated @RequestBody Librarian librarianDetails) {
        Librarian librarian  = librarianRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "librarian not found"));
       
        librarian.setId(librarianDetails.getId());
        librarian.setName(librarianDetails.getName());
        librarian.setUsername(librarianDetails.getUsername());
        librarian.setPassword(librarianDetails.getPassword());
        librarianRepository.save(librarian);
        return librarian;
    }

    public void deleteLibrarian(Long id) {
        librarianRepository.deleteById(id);
    }
}
