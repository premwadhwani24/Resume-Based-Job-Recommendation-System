package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Job entity containing details like title, description, and a list of required skills.
 * <p>
 * Immutable, thread-safe, and clearly defining its responsibility as a DTO.
 *
 * @param title          Title of the job position (non-null)
 * @param description    Detailed description about the job role (non-null)
 * @param requiredSkills Unmodifiable list of required skills for the job (non-null)
 */
public record Job(String title, String description, List<String> requiredSkills)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public Job {
        Objects.requireNonNull(title, "Job title must not be null");
        Objects.requireNonNull(description, "Job description must not be null");
        Objects.requireNonNull(requiredSkills, "Required skills must not be null");

        requiredSkills = List.copyOf(requiredSkills);
    }

}