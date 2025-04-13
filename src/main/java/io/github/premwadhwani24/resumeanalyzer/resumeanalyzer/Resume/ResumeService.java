package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Resume;

import java.util.List;
public interface ResumeService {

    Resume createResume(Resume resume);

    List<Resume> getAllResume();
    Resume getResumeByName(String name);

    Resume getResumeByEmail(String email);

    Resume getResumeBySkills(String skills);

    Resume getResumeByEducation(String eduction);

    Resume getResumeByExperience(String experience);
}