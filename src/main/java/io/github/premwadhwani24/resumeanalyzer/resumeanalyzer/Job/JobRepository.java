package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByTitleIgnoreCase(String title);

    Optional<Job> findByCompanyIgnoreCase(String company);

    Optional<Job> findByDescriptionIgnoreCase(String description);

    Optional<Job> findBySkillsRequiredIgnoreCase(String skills);

    Optional<Job> findByExperienceIgnoreCase(String experience);

    List<Job> findBySkillsRequiredContainingIgnoreCase(String skill);

    List<Job> findByLocationIgnoreCase(String location);
}
