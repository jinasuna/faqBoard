package com.tbl.faq.repository;


import com.tbl.faq.domain.dao.TblFaq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<TblFaq, Integer> {
    Page<TblFaq> findAll(Pageable pageable);
}
