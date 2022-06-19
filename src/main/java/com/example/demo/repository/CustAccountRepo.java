package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CustAccountDtlsVO;

public interface CustAccountRepo extends JpaRepository<CustAccountDtlsVO, Long> {

}
    

