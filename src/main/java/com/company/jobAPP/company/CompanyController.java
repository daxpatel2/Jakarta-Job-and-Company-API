package com.company.jobAPP.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controllers are used to define the apis
 */

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PutMapping("/update_company/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        if(companyService.updateCompany(id, company)) {
            return new ResponseEntity<>("Successfully updated company with id: "+id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Could not update company with with id: "+id,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Successfully created company: "+company.getName(),HttpStatus.OK);
    }

    @DeleteMapping("/delete_company/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean status = companyService.deleteCompany(id);
        return status ? new ResponseEntity<>("deleted succesfully",HttpStatus.OK) : new ResponseEntity<>("Couldn't deleted company",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCompany(@PathVariable Long id) {
        if(companyService.getCompany(id) != null) {
            return new ResponseEntity<>("Company found with id: "+id,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No comapny found",HttpStatus.BAD_REQUEST);
        }
    }
}
