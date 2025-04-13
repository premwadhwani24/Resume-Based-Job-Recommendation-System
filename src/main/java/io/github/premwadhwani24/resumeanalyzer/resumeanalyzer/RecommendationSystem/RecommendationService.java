package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.RecommendationSystem;

import java.util.List;

public interface RecommendationService<Recommendation, Recommedation, Recmmendation> {

    Recommendation createRecommendation(Recommendation recommendation);

    List<Recommendation> getAllRecommendation();

    Recommedation getRecommendationByTitle(String Title);

    Recommendation getRecommendationByComany(String Company);

    Recmmendation getRecommendationBySkills(String skills);

    Recommendation getRecommendationySkillsRequired(String skillsRequired);
}