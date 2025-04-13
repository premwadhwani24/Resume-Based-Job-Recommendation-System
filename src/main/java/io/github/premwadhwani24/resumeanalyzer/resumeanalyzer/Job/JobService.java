package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface JobService {

    Job createJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(long id);

    Job getJobByTitle(String title);

    Job getJobByCompany(String company);

    Job getJobByLocation(String location);

    Job getJobByDescription(String description);

    Job getJobBySkills(String skills);

    Job getJobByExperience(String experience);

    List<Job> getJobsBySkillsRequired(String skill);
    List<Job> getJobsByLocation(String location);
}