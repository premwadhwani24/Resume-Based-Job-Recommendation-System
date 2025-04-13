package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.RecommendationSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@Validated
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping
    public ResponseEntity<RecommendationSystem> createRecommendation(@RequestBody @Validated RecommendationSystem recommendation) {
        RecommendationSystem saved = recommendationService.createRecommendation(recommendation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecommendationSystem>> getAllRecommendations() {
        return ResponseEntity.ok(recommendationService.getAllRecommendation());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<RecommendationSystem>> getRecommendationByTitle(@PathVariable String title) {
        return ResponseEntity.ok(recommendationService.getRecommendationByTitle(title));
    }

    @GetMapping("/company/{company}")
    public ResponseEntity<List<RecommendationSystem>> getRecommendationByCompany(@PathVariable String company) {
        return ResponseEntity.ok(recommendationService.getRecommendationByCompany(company));
    }

    @GetMapping("/skills/{skills}")
    public ResponseEntity<List<RecommendationSystem>> getRecommendationBySkills(@PathVariable String skills) {
        return ResponseEntity.ok(recommendationService.getRecommendationBySkills(skills));
    }

    @GetMapping("/skillsRequired/{skillsRequired}")
    public ResponseEntity<List<RecommendationSystem>> getRecommendationBySkillsRequired(@PathVariable String skillsRequired) {
        return ResponseEntity.ok(recommendationService.getRecommendationBySkillsRequired(skillsRequired));
    }
}
