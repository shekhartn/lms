package com.photon.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leave_details")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "employee_code")
    private int employeeCode;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "leave_type")
    private String leaveType;
    @Column(name = "leave_status")
    private String leaveStatus;
    @Column(name = "no_of_days")
    private int noOfDays;
    @Column(name = "submitted_by")
    private String submittedBy;
    @Column(name = "submitted_date")
    private LocalDateTime submittedDate;
    @Column(name = "approved_by")
    private String approvedBy;
    @Column(name = "approved_date")
    private LocalDateTime approvedDate;
    private String email;
}
