package com.company.jobAPP.job;

import java.util.List;

/**
 * Defines only the methods not the implementations
 */
public interface JobService {
    List<Job> getJobs();
    String createJobs(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJob(Long id, Job job);
}
