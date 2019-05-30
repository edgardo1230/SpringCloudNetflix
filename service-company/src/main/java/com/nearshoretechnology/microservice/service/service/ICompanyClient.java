package com.nearshoretechnology.microservice.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "company-service", fallback = CompanyClientImpl.class)
public interface ICompanyClient {

    @RequestMapping(value = "/getCompany", method = RequestMethod.GET)
    String getCompany();


    @RequestMapping(value = "/addCompany", method = RequestMethod.POST)
    int addCompany();

}
