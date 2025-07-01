package com.msbte.notes.provider.msbte_notes_provider.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.msbte.notes.provider.msbte_notes_provider.Model.MSBTE;
public interface msbterepo extends JpaRepository<MSBTE, Integer>
{
         
}
