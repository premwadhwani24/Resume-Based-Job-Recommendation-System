package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.RecommendationSystem;

import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RecommendationService {

    List<Job> recommendJobsForUser(String username);

    RecommendationSystem createRecommendation(RecommendationSystem recommendation);

    List<RecommendationSystem> getAllRecommendation();

    List<RecommendationSystem> getRecommendationByTitle(String title);

    List<RecommendationSystem> getRecommendationByCompany(String company);

    List<RecommendationSystem> getRecommendationBySkills(String skills);

    List<RecommendationSystem> getRecommendationBySkillsRequired(String skillsRequired);
}
