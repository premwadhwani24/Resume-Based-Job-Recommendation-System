package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume;

import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.User.User;
import io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository, UserRepository userRepository) {
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Resume createResume(Resume resume) {
        // Set current upload date
        resume.setUploadedAt(LocalDate.now());

        // Validate associated user
        User user = userRepository.findById(resume.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + resume.getUser().getId()));
        resume.setUser(user);

        return resumeRepository.save(resume);
    }

    @Override
    public List<Resume> getAllResume() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume getResumeByName(String name) {
        return resumeRepository.findByFileName(name)
                .orElseThrow(() -> new RuntimeException("Resume not found with name: " + name));
    }

    @Override
    public Resume getResumeByEmail(String email) {
        return resumeRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Resume not found for email: " + email));
    }

    @Override
    public Resume getResumeBySkills(String skills) {
        return resumeRepository.findByParsedSkillsContainingIgnoreCase(skills)
                .orElseThrow(() -> new RuntimeException("Resume not found with skills: " + skills));
    }

    @Override
    public Resume getResumeByEducation(String education) {
        throw new UnsupportedOperationException("Education-based resume retrieval not implemented yet.");
    }

    @Override
    public Resume getResumeByExperience(String experience) {
        throw new UnsupportedOperationException("Experience-based resume retrieval not implemented yet.");
    }
}
