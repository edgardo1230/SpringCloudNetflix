package com.nearshoretechnology.microservice.service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class CompanyClientImpl implements ICompanyClient {
    private static int count = 1;

    @Value("${app.message:Default}")
    private String msg;

    @Value("${server.port}")
    private String port;

    @Override
    public String getCompany() {
        return "User(" + count + ") / getUserInfo()" + msg + " port:" + port;
    }

    @Override
    public int addCompany() {
        return ++count;
    }
}