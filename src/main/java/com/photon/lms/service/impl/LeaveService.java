package com.photon.lms.service.impl;

import com.photon.lms.dto.LeaveRequest;
import com.photon.lms.primary.entity.Leave;
import com.photon.lms.primary.repository.LeaveRepository;
import com.photon.lms.secondary.entity.SearchHistoryVO;
import com.photon.lms.secondary.repository.LeaveVMSRepository;
import com.photon.lms.service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class LeaveService implements ILeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private LeaveVMSRepository leaveVmsRepository;

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public List<Leave> getLeaveDetails(LeaveRequest leaveRequest) {
        return leaveRepository.findByEmployeeCodeAndFromDateAfter(leaveRequest.getEmployeeCode(), leaveRequest.getFromDate());
    }

    @Override
    public List<Leave> getLeaveDetailsByEmployeeCode(LeaveRequest leaveRequest) {
        return leaveRepository.findLeavesByEmployeeAndDateRange(leaveRequest.getEmployeeCode(), leaveRequest.getFromDate(), leaveRequest.getToDate());
    }


    @Override
    @Transactional(readOnly = true)
    public List<SearchHistoryVO> getTimeOffHistory(LeaveRequest leaveRequest) {
        System.out.println("LEAVE REQUEST::"+leaveRequest);

        return leaveVmsRepository.getLeaveDetails(
                leaveRequest.getEmployeeNumber(),
                getDate(leaveRequest.getFromDateVms()),
                getDate(leaveRequest.getToDateVms()),
                getDate(leaveRequest.getAppliedDate()),
                leaveRequest.getNumberOfDays(),
                leaveRequest.getLeaveType().isEmpty()?null:leaveRequest.getLeaveType(),
                getDate(leaveRequest.getApprovedDate()),
                leaveRequest.getLeaveStatus().isEmpty()?null:leaveRequest.getLeaveStatus(),
                leaveRequest.getOdOptionId());
    }
    private Date getDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date convertedDate=date!=null && !date.isEmpty()?java.sql.Date.valueOf(LocalDate.parse(date, formatter)):null;
        System.out.println("convertedDate:"+convertedDate);
        return convertedDate;
    }
}
