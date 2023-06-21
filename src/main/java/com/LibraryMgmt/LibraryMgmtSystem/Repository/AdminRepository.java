package com.LibraryMgmt.LibraryMgmtSystem.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibraryMgmt.LibraryMgmtSystem.models.Admin;


@Repository
public interface AdminRepository extends JpaRepository <Admin, Long>{

}
