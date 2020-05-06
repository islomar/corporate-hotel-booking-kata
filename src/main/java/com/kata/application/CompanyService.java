package com.kata.application;

import com.kata.domain.CompanyRepository;

public final class CompanyService {
	private final CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {

		this.companyRepository = companyRepository;
	}

	public void addEmployee(String companyId, String employeeId) {

	}
}
