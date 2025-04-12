package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import java.util.List;
import java.util.Objects;

public class Job {
    // The title of the job position
    private String title;

    // A detailed description of the job
    private String description;

    // A list of required skills for the job (e.g., Java, Spring Boot, etc.)
    private List<String> requiredSkills;

    // Default constructor (used by frameworks like Spring for object creation)
    public Job() {
    }

    // Parameterized constructor to initialize JobPOJO with specific values
    public Job(String title, String description, List<String> requiredSkills) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
    }

    // Getter for the title field
    public String getTitle() {
        return title;
    }

    // Setter for the title field
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the description field
    public String getDescription() {
        return description;
    }

    // Setter for the description field
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the requiredSkills field
    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    // Setter for the requiredSkills field
    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    // Overriding equals() to compare two JobPOJO objects based on their title, description, and requiredSkills
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(title, job.title) &&
                Objects.equals(description, job.description) &&
                Objects.equals(requiredSkills, job.requiredSkills);
    }

    // Overriding hashCode() for hashing purposes. It helps in efficient searching and retrieval (used by HashMap, HashSet, etc.)
    @Override
    public int hashCode() {
        return Objects.hash(title, description, requiredSkills);
    }

    // Overriding toString() to return a string representation of the JobPOJO object, useful for logging and debugging
    @Override
    public String toString() {
        return "JobPOJO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requiredSkills=" + requiredSkills +
                '}';
    }
}
