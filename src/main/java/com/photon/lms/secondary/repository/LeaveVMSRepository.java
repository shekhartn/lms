package com.photon.lms.secondary.repository;

import com.photon.lms.secondary.entity.SearchHistoryVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
public interface LeaveVMSRepository extends JpaRepository<SearchHistoryVO,String> {
    @Procedure(procedureName = "get_LMS_Employee_Leave_History_Search")
    List<SearchHistoryVO> getLeaveDetails(String employeeNumber, Date fromDate, Date toDate,Date appliedDate,Double noOfDays,String leaveType,Date approvedDate,String leaveStatus,int odOptionId);

}
