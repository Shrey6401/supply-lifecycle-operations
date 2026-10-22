package com.shrey.supplier_lifecycle_operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({
		"com.shrey.supplier_lifecycle_operations",
		"com.fsc.supply_chain_common_operations"
})
@SpringBootApplication
public class SupplierLifecycleOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierLifecycleOperationsApplication.class, args);
	}

}
