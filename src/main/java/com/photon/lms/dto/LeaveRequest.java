package com.photon.lms.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LeaveRequest {
    private Integer employeeCode;
    private LocalDate fromDate;
    private LocalDate toDate;

    private String fromDateVms;
    private String toDateVms;


    private String employeeNumber;
    private String appliedDate;
    private Double numberOfDays=0d;
    private String leaveType;
    private String approvedDate;
    private String leaveStatus;
    private int odOptionId=0;



}
