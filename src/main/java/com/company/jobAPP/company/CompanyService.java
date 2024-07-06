package com.company.jobAPP.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company company);
    void createCompany(Company company);
    boolean deleteCompany(Long id);
    Company getCompany(Long id);
}
