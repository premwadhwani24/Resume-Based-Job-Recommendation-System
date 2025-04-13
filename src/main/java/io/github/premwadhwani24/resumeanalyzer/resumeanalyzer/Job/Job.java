package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import java.util.List;
import java.util.Objects;

/**
 * Represents a Job entity containing job details like title, description, and required skills.
 * This acts as a POJO (Plain Old Java Object) used for job recommendations.
 */
public class Job {

    /** Title of the job position */
    private String title;

    /** Detailed description about the job role */
    private String description;

    /** List of required skills for the job (e.g., Java, Spring Boot, SQL) */
    private List<String> requiredSkills;

    /** No-argument constructor (required for frameworks like Spring) */
    public Job() {}

    /**
     * Parameterized constructor to initialize a Job object.
     *
     * @param title          Title of the job
     * @param description    Detailed job description
     * @param requiredSkills List of skills needed for this job
     */
    public Job(String title, String description, List<String> requiredSkills) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    /**
     * Checks if two Job objects are equal based on title, description, and required skills.
     *
     * @param o Object to compare with
     * @return true if all fields match, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return Objects.equals(title, job.title)
                && Objects.equals(description, job.description)
                && Objects.equals(requiredSkills, job.requiredSkills);
    }

    /**
     * Generates hash code based on title, description, and required skills.
     *
     * @return int hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, description, requiredSkills);
    }

    /**
     * Returns a string representation of the Job object.
     *
     * @return String describing the job
     */
    @Override
    public String toString() {
        return "Job{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requiredSkills=" + requiredSkills +
                '}';
    }
}
