package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.RecommendationSystem;

import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job.Job;
import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job.JobRepository;
import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume.Resume;
import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final ResumeRepository resumeRepository;
    private final JobRepository jobRepository;
    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationServiceImpl(ResumeRepository resumeRepository,
                                     JobRepository jobRepository,
                                     RecommendationRepository recommendationRepository) {
        this.resumeRepository = resumeRepository;
        this.jobRepository = jobRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<Job> recommendJobsForUser(String username) {
        Resume resume = resumeRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException("Resume not found for user: " + username));

        String[] skills = resume.getSkills(",").toArray(new String[0]);
        Set<Job> matchedJobs = new HashSet<>();

        for (String skill : skills) {
            matchedJobs.addAll(jobRepository.findBySkillsRequiredContainingIgnoreCase(skill.trim()));
        }

        return new ArrayList<>(matchedJobs);
    }

    @Override
    public RecommendationSystem createRecommendation(RecommendationSystem recommendation) {
        return recommendationRepository.save(recommendation);
    }

    @Override
    public List<RecommendationSystem> getAllRecommendation() {
        return recommendationRepository.findAll();
    }

    @Override
    public List<RecommendationSystem> getRecommendationByTitle(String title) {
        return recommendationRepository.findByJob_TitleIgnoreCase(title);
    }

    @Override
    public List<RecommendationSystem> getRecommendationByCompany(String company) {
        return recommendationRepository.findByJob_CompanyIgnoreCase(company);
    }

    @Override
    public List<RecommendationSystem> getRecommendationBySkills(String skills) {
        return recommendationRepository.findByJob_SkillsRequiredContainingIgnoreCase(skills);
    }

    @Override
    public List<RecommendationSystem> getRecommendationBySkillsRequired(String skillsRequired) {
        return recommendationRepository.findByJob_SkillsRequiredContainingIgnoreCase(skillsRequired);
    }
}
