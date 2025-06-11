package com.photon.lms.service;

import com.photon.lms.dto.LeaveRequest;
import com.photon.lms.primary.entity.Leave;
import com.photon.lms.secondary.entity.SearchHistoryVO;

import java.util.List;

public interface ILeaveService {
    List<Leave> getAllLeaves();

    List<Leave> getLeaveDetails(LeaveRequest leaveRequest);

    List<Leave> getLeaveDetailsByEmployeeCode(LeaveRequest leaveRequest);

    List<SearchHistoryVO> getTimeOffHistory(LeaveRequest leaveRequest);
}
