package com.shrey.supplier_lifecycle_operations.Controller;

import com.fsc.supply_chain_common_operations.Models.SupplierCompany;
import com.shrey.supplier_lifecycle_operations.Services.SupplierCompanyService;
import com.shrey.supplier_lifecycle_operations.dtos.Requests.SupplierCompanyRegistrationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/slo/company")
public class SupplierCompanyController {

    private final SupplierCompanyService supplierCompanyService;

    @Autowired
    public SupplierCompanyController(
            SupplierCompanyService supplierCompanyService
    ) {
        this.supplierCompanyService = supplierCompanyService;
    }

    @PostMapping("/register")
    public ResponseEntity<SupplierCompany> registerSupplierCompany(
            @RequestBody SupplierCompanyRegistrationRequest request
    ) {
        SupplierCompany supplierCompany =
                supplierCompanyService.registerSupplierCompany(request);

        return new ResponseEntity<>(supplierCompany, HttpStatus.CREATED);
    }
}