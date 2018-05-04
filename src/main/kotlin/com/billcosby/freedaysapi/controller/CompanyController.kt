package com.billcosby.freedaysapi.controller

import com.billcosby.freedaysapi.model.Company
import com.billcosby.freedaysapi.repository.CompanyRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class CompanyController(private val companyRepository: CompanyRepository) {

    @GetMapping("/companies")
    fun companies(): List<Company> = companyRepository.findAll()

    @PostMapping("/companies")
    fun createCompany(@Valid @RequestBody company: Company): Company = companyRepository.save(company)

    @GetMapping("/companies/{id}")
    fun companyById(@PathVariable(value = "id") companyId: Long): ResponseEntity<Company> {
        return companyRepository.findById(companyId)
                .map { company -> ResponseEntity.ok(company) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/companies/{id}")
    fun updateCompany(@PathVariable(value = "id") companyId: Long,
                      @Valid @RequestBody newCompany: Company): ResponseEntity<Company> {

        return companyRepository.findById(companyId)
                .map { existingCompany ->
                    val updatedCompany = existingCompany.copy(name = newCompany.name)
                    ResponseEntity.ok().body(companyRepository.save(updatedCompany))

                }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/companies/{id}")
    fun deleteCompany(@PathVariable(value = "id") companyId: Long): ResponseEntity<Void> {

        return companyRepository.findById(companyId)
                .map { company ->
                    companyRepository.delete(company)
                    ResponseEntity<Void>(HttpStatus.OK)
                }.orElse(ResponseEntity.notFound().build())
    }
}