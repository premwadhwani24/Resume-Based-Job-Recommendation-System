package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing job listings in the Resume Analyzer application.
 * Provides endpoints for CRUD operations and search queries on job data.
 */
@RestController
@RequestMapping("/api/jobs")
@Validated
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService JobService) {
        this.jobService = JobService;
    }
    /**
     * Creates a new job listing.
     *
     * @param job The job information to create
     * @return The created job with HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Job> createJob(@Valid @RequestBody Job job) {
        Job savedJob = jobService.createJob(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    /**
     * Retrieves all jobs from the system.
     *
     * @return List of all job listings
     */
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    /**
     * Retrieves a job by its ID.
     *
     * @param id Job ID (must be positive)
     * @return Job with given ID, or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable @Positive long id) {
        Job job = jobService.getJobById(id);
        return (job != null) ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a job by its title.
     *
     * @param title Job title (must not be blank)
     * @return Job with given title, or 404 if not found
     */
    @GetMapping("/byTitle")
    public ResponseEntity<Job> getJobByTitle(@RequestParam @NotBlank String title) {
        Job job = jobService.getJobByTitle(title);
        return (job != null) ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a job by its company name.
     *
     * @param company Company name (must not be blank)
     * @return Job with given company, or 404 if not found
     */
    @GetMapping("/byCompany")
    public ResponseEntity<Job> getJobByCompany(@RequestParam @NotBlank String company) {
        Job job = jobService.getJobByCompany(company);
        return (job != null) ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a job by its location.
     *
     * @param location Location name (must not be blank)
     * @return Job with given location, or 404 if not found
     */
    @GetMapping("/byLocation")
    public ResponseEntity<Job> getJobByLocation(@RequestParam @NotBlank String location) {
        Job job = jobService.getJobByLocation(location);
        return (job != null) ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a job by its description.
     *
     * @param description Job description (must not be blank)
     * @return Job with given description, or 404 if not found
     */
    @GetMapping("/byDescription")
    public ResponseEntity<Job> getJobByDescription(@RequestParam @NotBlank String description) {
        Job job = jobService.getJobByDescription(description);
        return (job != null) ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a job by required skills.
     *
     * @param skills Required skills (comma-separated, must not be blank)
     * @return Job with given skill set, or 404 if not found
     */
    @GetMapping("/bySkills")
    public ResponseEntity<Job> getJobBySkills(@RequestParam @NotBlank String skills) {
        Job job = jobService.getJobBySkills(skills);
        return (job != null) ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a job by experience requirement.
     *
     * @param experience Experience required (must not be blank)
     * @return Job with given experience requirement, or 404 if not found
     */
    @GetMapping("/byExperience")
    public ResponseEntity<Job> getJobByExperience(@RequestParam @NotBlank String experience) {
        Job job = jobService.getJobByExperience(experience);
        return (job != null) ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    // Optional: Add update and delete endpoints as needed.

}
