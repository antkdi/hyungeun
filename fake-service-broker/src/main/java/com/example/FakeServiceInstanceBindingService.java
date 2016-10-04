package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
public class FakeServiceInstanceBindingService implements ServiceInstanceBindingService {

    @Override
    public CreateServiceInstanceBindingResponse createServiceInstanceBinding(CreateServiceInstanceBindingRequest req) {
        String serviceInstanceId = req.getServiceInstanceId();
        String bindingId = req.getBindingId();
        //log.info("Create Service Binding({}) for Service({})", bindingId, serviceInstanceId);
        System.out.println("Create Service Binding("+bindingId+") for Service({"+serviceInstanceId+"})");
        
        Map<String, Object> credentials = new HashMap<String, Object>() {{
            put("url", "http://example.com/" + UUID.randomUUID());
            put("username", UUID.randomUUID());
            put("password", UUID.randomUUID());
        }};
        return new CreateServiceInstanceAppBindingResponse().withCredentials(credentials);
    }

    @Override
    public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest req) {
        String serviceInstanceId = req.getServiceInstanceId();
        String bindingId = req.getBindingId();
        //log.info("Delete Service Binding({}) for Service({})", bindingId, serviceInstanceId);
        System.out.println("Create Service Binding("+bindingId+") for Service({"+serviceInstanceId+"})");
    }
}
