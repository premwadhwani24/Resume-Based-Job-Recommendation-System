package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Optional<Resume> findByFileName(String fileName);

    Optional<Resume> findByUserEmail(String email); // Use user.email to filter

    Optional<Resume> findByParsedSkillsContainingIgnoreCase(String skills);

    Optional<Resume> findByUsernameIgnoreCase(String username);
}
