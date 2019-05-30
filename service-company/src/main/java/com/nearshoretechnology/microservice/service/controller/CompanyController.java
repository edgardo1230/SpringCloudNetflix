package com.nearshoretechnology.microservice.service.controller;

import com.nearshoretechnology.microservice.service.service.ICompanyClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private ICompanyClient client;

    @HystrixCommand(fallbackMethod = "hystrixError")
    @RequestMapping("/getCompany")
    public String getCompany() {
        return client.getCompany();
    }

    @HystrixCommand(fallbackMethod = "hystrixError")
    @RequestMapping("/addCompany")
    public String addCompany() {
        return String.valueOf(client.addCompany());
    }

    public String hystrixError() {
        return "FeignHystrix / hystrix(): Service Unavailable";
    }

}
