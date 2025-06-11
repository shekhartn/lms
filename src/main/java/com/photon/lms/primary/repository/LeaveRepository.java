package com.photon.lms.primary.repository;


import com.photon.lms.primary.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Integer>, LeaveRepositoryCustom {

    List<Leave> findByEmployeeCodeAndFromDateAfter(Integer employeeCode, LocalDate fromDate);
}
