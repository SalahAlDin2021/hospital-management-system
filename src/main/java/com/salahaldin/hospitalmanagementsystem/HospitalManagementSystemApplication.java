package com.salahaldin.hospitalmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HospitalManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementSystemApplication.class, args);
    }

//    @GetMapping(value = "/hospital")
//    public List<CustomerDto> getSCustomers() {
//        List<CustomerDto> customerList = new ArrayList<CustomerDto>();
//        for (int i = 0; i < 5; i++) {
//            customerList.add(new CustomerDto("name" + i, "lastname" + i));
//        }
//        return customerList;
//    }

}
