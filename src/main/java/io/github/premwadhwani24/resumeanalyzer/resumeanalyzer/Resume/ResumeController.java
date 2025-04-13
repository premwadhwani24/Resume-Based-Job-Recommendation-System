package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing user resumes.
 */
@RestController
@RequestMapping("/api/resumes")
@Validated
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    /**
     * Create a new resume entry.
     */
    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody @Validated Resume resume) {
        Resume savedResume = resumeService.createResume(resume);
        return new ResponseEntity<>(savedResume, HttpStatus.CREATED);
    }

    /**
     * Retrieve all resumes.
     */
    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {
        return ResponseEntity.ok(resumeService.getAllResume());
    }

    /**
     * Get resume by user name.
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Resume> getResumeByName(@PathVariable String name) {
        return ResponseEntity.ok(resumeService.getResumeByName(name));
    }

    /**
     * Get resume by user email.
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<Resume> getResumeByEmail(@PathVariable String email) {
        return ResponseEntity.ok(resumeService.getResumeByEmail(email));
    }

    /**
     * Get resume by parsed skills.
     */
    @GetMapping("/skills/{skills}")
    public ResponseEntity<Resume> getResumeBySkills(@PathVariable String skills) {
        return ResponseEntity.ok(resumeService.getResumeBySkills(skills));
    }

    /**
     * Get resume by education.
     */
    @GetMapping("/education/{education}")
    public ResponseEntity<Resume> getResumeByEducation(@PathVariable String education) {
        return ResponseEntity.ok(resumeService.getResumeByEducation(education));
    }

    /**
     * Get resume by experience.
     */
    @GetMapping("/experience/{experience}")
    public ResponseEntity<Resume> getResumeByExperience(@PathVariable String experience) {
        return ResponseEntity.ok(resumeService.getResumeByExperience(experience));
    }
}
