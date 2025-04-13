package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.RecommendationSystem;

import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationSystem, Long> {
    Optional<Resume> findByUsernameIgnoreCase(String username);

    List<RecommendationSystem> findByJob_TitleIgnoreCase(String title);

    List<RecommendationSystem> findByJob_CompanyIgnoreCase(String company);

    List<RecommendationSystem> findByJob_SkillsRequiredContainingIgnoreCase(String skills);

    List<RecommendationSystem> findByMatchScoreGreaterThanEqual(double matchScore);
}
