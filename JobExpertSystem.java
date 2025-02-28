package com.example.jes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class JobExpertSystem {

    @GetMapping
    public String getForm() {
        return "<form action='/process' method='post'>" +
                "Degree: <input type='text' name='degree' placeholder='Bachelor, Masters' required/><br>" +
                "Completed Python Course: " +
                "<select name='pythonCourse'><option value='true'>True</option><option value='false'>False</option></select><br>" +
                "Completed Software Engineering Course: " +
                "<select name='softwareEngCourse'><option value='true'>True</option><option value='false'>False</option></select><br>" +
                "Completed Agile Course: " +
                "<select name='agileCourse'><option value='true'>True</option><option value='false'>False</option></select><br>" +
                "Years of Python Development Experience: <input type='number' name='pythonExperience' required/><br>" +
                "Years of Data Development Experience: <input type='number' name='dataExperience' required/><br>" +
                "Years of Project Management Experience: <input type='number' name='projectManagementExperience' required/><br>" +
                "Years of Agile Project Experience: <input type='number' name='agileProjectExperience' required/><br>" +
                "Used Git: " +
                "<select name='usedGit'><option value='true'>True</option><option value='false'>False</option></select><br>" +
                "PMI Lean Project Management Certification: " +
                "<select name='hasPMICert'><option value='true'>True</option><option value='false'>False</option></select><br>" +
                "Has a Master's Degree: " +
                "<select name='hasMasters'><option value='true'>True</option><option value='false'>False</option></select><br>" +
                "<button type='submit'>Submit</button>" +
                "</form>";
    }

    @PostMapping
    public String processInput(
            @RequestParam String degree,
            @RequestParam boolean pythonCourse,
            @RequestParam boolean softwareEngCourse,
            @RequestParam boolean agileCourse,
            @RequestParam int pythonExperience,
            @RequestParam int dataExperience,
            @RequestParam int projectManagementExperience,
            @RequestParam int agileProjectExperience,
            @RequestParam boolean usedGit,
            @RequestParam boolean hasPMICert,
            @RequestParam boolean hasMasters) {

        StringBuilder result = new StringBuilder("<h2>Application Results</h2>");

        boolean qualified = false;

        if (pythonExperience >= 3 && dataExperience >= 1 && agileProjectExperience >= 1
                && usedGit && "Bachelor in CS".equalsIgnoreCase(degree)) {
            result.append("<p>✅ Accepted for Python Engineer position.</p>");
            qualified = true;
        } else {
            result.append("<p>❌ Denied for Python Engineer position.</p>");
        }

        if (projectManagementExperience >= 3 && agileProjectExperience >= 2 && hasPMICert) {
            result.append("<p>✅ Accepted for Project Manager position.</p>");
            qualified = true;
        } else {
            result.append("<p>❌ Denied for Project Manager position.</p>");
        }

        if (pythonExperience >= 3 && dataExperience >= 2 && hasMasters) {
            result.append("<p>✅ Accepted for Senior Knowledge Engineer position.</p>");
            qualified = true;
        } else {
            result.append("<p>❌ Denied for Senior Knowledge Engineer position.</p>");
        }

        if (pythonCourse && softwareEngCourse && "Bachelor in CS".equalsIgnoreCase(degree)) {
            result.append("<p>✅ Accepted for Entry-Level Python Engineer position.</p>");
            qualified = true;
        } else {
            result.append("<p>❌ Denied for Entry-Level Python Engineer position.</p>");
        }

        if (!qualified) {
            result.append("<p>⚠️ You do not meet the qualifications for any available positions.</p>");
        }

        result.append("<br><a href='/process'>Try Again</a>");
        return result.toString();
    }
}
