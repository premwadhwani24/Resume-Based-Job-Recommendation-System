package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(long id) {
        return null;
    }

    @Override
    public Job getJobByTitle(String title) {
        return jobRepository.findByTitleIgnoreCase(title)
                .orElseThrow(() -> new RuntimeException("Job not found with title: " + title));
    }

    @Override
    public Job getJobByCompany(String company) {
        return jobRepository.findByCompanyIgnoreCase(company)
                .orElseThrow(() -> new RuntimeException("Job not found with company: " + company));
    }

    @Override
    public Job getJobByLocation(String location) {
        return null;
    }

    @Override
    public Job getJobByDescription(String description) {
        return jobRepository.findByDescriptionIgnoreCase(description)
                .orElseThrow(() -> new RuntimeException("Job not found with description: " + description));
    }

    @Override
    public Job getJobBySkills(String skills) {
        return jobRepository.findBySkillsRequiredIgnoreCase(skills)
                .orElseThrow(() -> new RuntimeException("Job not found with skills: " + skills));
    }

    @Override
    public Job getJobByExperience(String experience) {
        return jobRepository.findByExperienceIgnoreCase(experience)
                .orElseThrow(() -> new RuntimeException("Job not found with experience: " + experience));
    }

    @Override
    public List<Job> getJobsBySkillsRequired(String skill) {
        return jobRepository.findBySkillsRequiredContainingIgnoreCase(skill);
    }

    @Override
    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocationIgnoreCase(location);
    }
}
