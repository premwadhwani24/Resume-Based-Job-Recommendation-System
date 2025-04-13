package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.Job;

import java.util.List;
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
}