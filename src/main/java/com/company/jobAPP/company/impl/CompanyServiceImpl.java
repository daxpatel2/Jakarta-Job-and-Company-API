package com.company.jobAPP.company.impl;

import com.company.jobAPP.company.Company;
import com.company.jobAPP.company.CompanyRepository;
import com.company.jobAPP.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()) {
            Company updatedCompany = companyOptional.get();
            updatedCompany.setDescription(company.getDescription());
            updatedCompany.setJobs(company.getJobs());
            updatedCompany.setName(company.getName());
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            throw new IllegalStateException("Company with that id doesnt not exist");
        }
    }

    /**
     *
     * @param id id number of the company to find
     * @return null if company does not exist
     */
    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
