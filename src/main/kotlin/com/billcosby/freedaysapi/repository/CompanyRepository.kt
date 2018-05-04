package com.billcosby.freedaysapi.repository

import com.billcosby.freedaysapi.model.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository: JpaRepository<Company, Long>