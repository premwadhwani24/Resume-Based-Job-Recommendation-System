package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ResumeService {

    Resume createResume(Resume resume);

    List<Resume> getAllResume();
    Resume getResumeByName(String name);

    Resume getResumeByEmail(String email);

    Resume getResumeBySkills(String skills);

    Resume getResumeByEducation(String eduction);

    Resume getResumeByExperience(String experience);
}