package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume;

import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

// Entity representing a user's uploaded resume
@Entity
@Table(name = "resumes")
@Getter // Generates getter methods
@Setter // Generates setter methods
@NoArgsConstructor // Default constructor needed by JPA
@AllArgsConstructor // Constructor initializing all fields
@ToString // Provides a descriptive string representation
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Equals and hashCode based only on id
class Resume {

    // Primary key generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    // Original file name of the resume, must not be blank
    @NotBlank(message = "File name is required.")
    private String fileName;

    // Extracted skills from resume text (can be empty or null)
    @Column(length = 1000)
    private String parsedSkills;

    // Date when resume was uploaded; must not be future date
    @PastOrPresent(message = "Upload date must be today or in the past.")
    private LocalDate uploadedAt;

    // Reference to the associated user entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}