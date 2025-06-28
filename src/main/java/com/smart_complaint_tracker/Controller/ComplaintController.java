package com.smart_complaint_tracker.Controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.smart_complaint_tracker.Entity.Complaint;
import com.smart_complaint_tracker.Entity.User;
import com.smart_complaint_tracker.Service.ComplaintService;
import com.smart_complaint_tracker.Service.UserService;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Complaint> complaints = complaintService.getAllComplaints();
        model.addAttribute("complaints", complaints);
        return "dashboard";
    }

    @GetMapping("/complaint/new")
    public String showComplaintForm(Model model) {
        model.addAttribute("complaint", new Complaint());
        return "complaint_form";
    }

    @PostMapping("/complaint/save")
    public String submitComplaint(@ModelAttribute Complaint complaint, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        complaint.setUser(user);
        complaintService.saveComplaint(complaint);
        return "redirect:/dashboard";
    }

    @PostMapping("/complaint/{id}/upvote")
    @ResponseBody
    public int upvoteComplaint(@PathVariable Long id) {
        Complaint complaint = complaintService.upvoteComplaint(id);
        return complaint.getUpvotes();
    }


}

