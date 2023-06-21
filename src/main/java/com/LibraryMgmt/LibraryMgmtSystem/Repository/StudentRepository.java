package com.LibraryMgmt.LibraryMgmtSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibraryMgmt.LibraryMgmtSystem.models.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
