package com.mvc.cloud_service.comm;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetEurekaClientUrl {

    @Autowired
    private  EurekaClient eurekaClient;

    public  String getUrl(String service){
        System.out.println(eurekaClient.getApplications().toString());
        Applications app=eurekaClient.getApplications();
        InstanceInfo instance=(InstanceInfo)eurekaClient.getNextServerFromEureka(service,false);
        System.out.println(instance.getHomePageUrl());
        return instance.getHomePageUrl();
    }
}
