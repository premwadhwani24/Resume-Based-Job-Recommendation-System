package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.RecommendationSystem;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RecommendationService<Recommendation, Recommedation, Recmmendation> {

    Recommendation createRecommendation(Recommendation recommendation);

    List<Recommendation> getAllRecommendation();

    Recommedation getRecommendationByTitle(String Title);

    Recommendation getRecommendationByComany(String Company);

    Recmmendation getRecommendationBySkills(String skills);

    Recommendation getRecommendationySkillsRequired(String skillsRequired);
}

