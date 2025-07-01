package com.msbte.notes.provider.msbte_notes_provider.Repository;
import com.msbte.notes.provider.msbte_notes_provider.Model.admin;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//@Repository
public interface adminRepo extends JpaRepository<admin, Long> 
{

    admin findByEmail(String email);

}
