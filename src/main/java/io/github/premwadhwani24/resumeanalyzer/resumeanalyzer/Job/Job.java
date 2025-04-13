package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;

/**
 * Job entity represents the job data stored in the database for the resume analyzer.
 */
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Job title cannot be empty.")
    private String title;

    @NotBlank(message = "Qualification cannot be empty.")
    private String qualification;

    @ElementCollection
    @CollectionTable(name = "job_skills", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "skill")
    private List<String> skillSet;

    @NotBlank(message = "Experience field is required.")
    private String experience;

    @NotBlank(message = "Location cannot be empty.")
    private String location;

    @NotBlank(message = "Salary range must be provided.")
    private String salaryRange;

    @NotBlank(message = "Contact details are required.")
    private String contactDetails;

    public Job() {
    }

    public Job(String title, String qualification, List<String> skillSet, String experience, String location, String salaryRange, String contactDetails) {
        this.title = title;
        this.qualification = qualification;
        this.skillSet = skillSet;
        this.experience = experience;
        this.location = location;
        this.salaryRange = salaryRange;
        this.contactDetails = contactDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<String> skillSet) {
        this.skillSet = skillSet;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", qualification='" + qualification + '\'' +
                ", skillSet=" + skillSet +
                ", experience='" + experience + '\'' +
                ", location='" + location + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }
}
