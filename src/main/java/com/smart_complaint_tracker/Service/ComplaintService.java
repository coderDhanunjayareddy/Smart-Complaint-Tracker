package com.smart_complaint_tracker.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.smart_complaint_tracker.Entity.Complaint;
import com.smart_complaint_tracker.Repository.ComplaintRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public List<Complaint> getComplaintsByUser(Long userId) {
        return complaintRepository.findByUserId(userId);
    }

    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    public Complaint upvoteComplaint(Long id) {
        Complaint complaint = complaintRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
        complaint.setUpvotes(complaint.getUpvotes() + 1);
        complaintRepository.save(complaint);
        return complaint;
    }


    
}

