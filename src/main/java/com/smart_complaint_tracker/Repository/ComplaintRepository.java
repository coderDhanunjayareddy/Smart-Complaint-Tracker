package com.smart_complaint_tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smart_complaint_tracker.Entity.Complaint;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByUserId(Long userId);
}

