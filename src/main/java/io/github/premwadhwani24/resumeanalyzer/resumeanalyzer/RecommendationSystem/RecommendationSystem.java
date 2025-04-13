package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.RecommendationSystem;

import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.User.User;
import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job.Job;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "recommendations")
public class RecommendationSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Min(value = 0, message = "Match score must be 0 or more.")
    private double matchScore;

    @PastOrPresent(message = "Recommendation date must be today or in the past.")
    private LocalDate recommendedAt;

    public RecommendationSystem() {
    }

    public RecommendationSystem(Long id, User user, Job job, double matchScore, LocalDate recommendedAt) {
        this.id = id;
        this.user = user;
        this.job = job;
        this.matchScore = matchScore;
        this.recommendedAt = recommendedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }

    public LocalDate getRecommendedAt() {
        return recommendedAt;
    }

    public void setRecommendedAt(LocalDate recommendedAt) {
        this.recommendedAt = recommendedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecommendationSystem that)) return false;
        return Double.compare(matchScore, that.matchScore) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(job, that.job) &&
                Objects.equals(recommendedAt, that.recommendedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, job, matchScore, recommendedAt);
    }

    @Override
    public String toString() {
        return "RecommendationSystem{" +
                "id=" + id +
                ", user=" + user +
                ", job=" + job +
                ", matchScore=" + matchScore +
                ", recommendedAt=" + recommendedAt +
                '}';
    }
}
