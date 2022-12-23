package com.hsnbrji.numberconverter.repository;

import com.hsnbrji.numberconverter.domain.ConversionAudit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionAuditRepository extends JpaRepository<ConversionAudit, Integer> {

    List<ConversionAudit> findAll();

}
