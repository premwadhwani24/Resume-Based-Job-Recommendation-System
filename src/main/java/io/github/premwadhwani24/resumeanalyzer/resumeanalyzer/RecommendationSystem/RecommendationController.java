package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.RecommendationSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing job recommendations.
 */
@RestController
@RequestMapping("/api/recommendations")
@Validated
public class RecommendationController {

    private final RecommendationService<RecommendationSystem, RecommendationSystem, RecommendationSystem> recommendationService;

    @Autowired
    public RecommendationController(RecommendationService<RecommendationSystem, RecommendationSystem, RecommendationSystem> recommendationService) {
        this.recommendationService = recommendationService;
    }

    /**
     * Create a new recommendation.
     */
    @PostMapping
    public ResponseEntity<RecommendationSystem> createRecommendation(@RequestBody @Validated RecommendationSystem recommendation) {
        RecommendationSystem savedRecommendation = recommendationService.createRecommendation(recommendation);
        return new ResponseEntity<>(savedRecommendation, HttpStatus.CREATED);
    }

    /**
     * Get all recommendations.
     */
    @GetMapping
    public ResponseEntity<List<RecommendationSystem>> getAllRecommendations() {
        return ResponseEntity.ok(recommendationService.getAllRecommendation());
    }

    /**
     * Get recommendation by job title.
     */
    @GetMapping("/title/{title}")
    public ResponseEntity<RecommendationSystem> getRecommendationByTitle(@PathVariable String title) {
        return ResponseEntity.ok(recommendationService.getRecommendationByTitle(title));
    }

    /**
     * Get recommendation by company name.
     */
    @GetMapping("/company/{company}")
    public ResponseEntity<RecommendationSystem> getRecommendationByCompany(@PathVariable String company) {
        return ResponseEntity.ok(recommendationService.getRecommendationByComany(company));
    }

    /**
     * Get recommendation by required skill.
     */
    @GetMapping("/skills/{skills}")
    public ResponseEntity<RecommendationSystem> getRecommendationBySkills(@PathVariable String skills) {
        return ResponseEntity.ok(recommendationService.getRecommendationBySkills(skills));
    }

    /**
     * Get recommendation by skills required.
     */
    @GetMapping("/skillsRequired/{skillsRequired}")
    public ResponseEntity<RecommendationSystem> getRecommendationBySkillsRequired(@PathVariable String skillsRequired) {
        return ResponseEntity.ok(recommendationService.getRecommendationySkillsRequired(skillsRequired));
    }
}
