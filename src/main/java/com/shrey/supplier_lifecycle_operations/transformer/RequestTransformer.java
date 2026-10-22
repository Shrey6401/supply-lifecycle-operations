package com.shrey.supplier_lifecycle_operations.transformer;

import com.fsc.supply_chain_common_operations.Models.SupplierCompany;
import com.fsc.supply_chain_common_operations.Utilities.SystemUtility;
import com.fsc.supply_chain_common_operations.enums.CompanyStatus;

import com.shrey.supplier_lifecycle_operations.dtos.Requests.SupplierCompanyRegistrationRequest;

import java.time.LocalDateTime;

public class RequestTransformer {

    public static SupplierCompany mapRegistrationRequestToSupplierCompany(
            SupplierCompanyRegistrationRequest request
    ){
        // I will map request to model
        SupplierCompany supplierCompany = SupplierCompany.builder()
                .supplierCategory(request.getSupplierCategory())
                .leadTimeDays(request.getLeadTimeDays())
                .minimumOrderValue(request.getMinimumOrderValue())

                .companyName(request.getCompanyName())
                .legalName(request.getLegalName())
                .gstNumber(request.getGstNumber())
                .panNumber(request.getPanNumber())
                .emailAddress(request.getEmailAddress())
                .website(request.getWebsite())
                .contactNumber(request.getContactNumber())

                .companyCode(SystemUtility.generateId("COMP"))
                .supplierCode(SystemUtility.generateId("SUPPLIER"))
                .status(CompanyStatus.PENDING)

                .createdAt(LocalDateTime.now())
                .createdBy("system")
                .updatedAt(LocalDateTime.now())
                .updatedBy("system")

                .build();

        return supplierCompany;
    }

}