package com.photon.lms.controller;


import com.photon.lms.dto.ContactInfoDto;
import com.photon.lms.dto.AuthRequest;
import com.photon.lms.dto.LeaveRequest;
import com.photon.lms.primary.entity.Leave;
import com.photon.lms.secondary.entity.SearchHistoryVO;
import com.photon.lms.service.ILeaveService;
import com.photon.lms.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/lms")
public class LeaveController {
    private static final Logger logger = LoggerFactory.getLogger(LeaveController.class);
    @Autowired
    private ILeaveService service;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ContactInfoDto contactInfo;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Leave> getAllTheProducts() {
        return service.getAllLeaves();
    }

    @PostMapping("/getLeaveDetails")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Leave> getLeaveDetails(@RequestBody LeaveRequest leaveRequest) {
        return service.getLeaveDetails(leaveRequest);
    }

    @PostMapping("/getLeaveDetailsByEmployeeCode")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Leave> getLeaveDetailsByEmployeeCode(@RequestBody LeaveRequest leaveRequest) {
        return service.getLeaveDetailsByEmployeeCode(leaveRequest);
    }

    @PostMapping("/gettimeoffhistory")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<SearchHistoryVO> getTimeOffHistory(@RequestBody LeaveRequest leaveRequest) {
        return service.getTimeOffHistory(leaveRequest);
    }


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }

    @GetMapping("/contact-info")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ContactInfoDto> getContactInfo() {
        logger.info("Leave API called");
        return ResponseEntity.ok(contactInfo);
    }
}