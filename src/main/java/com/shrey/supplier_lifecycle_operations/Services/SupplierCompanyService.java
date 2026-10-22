package com.shrey.supplier_lifecycle_operations.Services;

import com.fsc.supply_chain_common_operations.Models.SupplierCompany;
import com.fsc.supply_chain_common_operations.Service.EmployeeService;
import com.fsc.supply_chain_common_operations.enums.CompanyType;
import com.fsc.supply_chain_common_operations.repositories.SupplierCompanyRepo;
import com.shrey.supplier_lifecycle_operations.dtos.Requests.SupplierCompanyRegistrationRequest;

import com.shrey.supplier_lifecycle_operations.transformer.RequestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierCompanyService {

    private final SupplierCompanyRepo supplierCompanyRepo;
    private final EmployeeService employeeService;

    @Autowired
    public SupplierCompanyService(
            SupplierCompanyRepo supplierCompanyRepo,
            EmployeeService employeeService) {

        this.supplierCompanyRepo = supplierCompanyRepo;
        this.employeeService = employeeService;
    }

    public SupplierCompany registerSupplierCompany(
            SupplierCompanyRegistrationRequest request) {

        SupplierCompany supplierCompany =
                RequestTransformer.mapRegistrationRequestToSupplierCompany(request);

        supplierCompany = saveOrUpdate(supplierCompany);

        employeeService.createMaintUserForCompany(
                supplierCompany,
                CompanyType.SUPPLIER_COMPANY
        );

        return supplierCompany;
    }

    public SupplierCompany saveOrUpdate(SupplierCompany supplierCompany) {
        return supplierCompanyRepo.save(supplierCompany);
    }
}