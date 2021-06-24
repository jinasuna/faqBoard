package com.tbl.faq.repository;


import com.tbl.faq.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Integer> {
    List<Faq> findAllByOrderByRegDateAsc();
    List<Faq> findAllByOrderByRegDateDesc();
}
