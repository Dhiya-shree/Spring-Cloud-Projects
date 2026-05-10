package com.mvc.cloud_service.service;

import com.mvc.cloud_service.comm.AddressHttpExchange;
import com.mvc.cloud_service.comm.AddressServiceFeignClient;
import com.mvc.cloud_service.comm.AddressTransService;
import com.mvc.cloud_service.dto.AddressResponse;
import com.mvc.cloud_service.dto.InfoRequest;
import com.mvc.cloud_service.dto.InfoResponse;
import com.mvc.cloud_service.entity.Information;
import com.mvc.cloud_service.repository.InformationRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@SuppressWarnings("unused")
public class InfoServiceImpl implements InfoService {
    private static Logger logger= LoggerFactory.getLogger(InfoServiceImpl.class);
    InformationRepository repo;
    InfoServiceImpl(InformationRepository repo){
        this.repo=repo;
    }
    @Override
    public InfoResponse createInfo(InfoRequest request) {
        Information info=new Information();
        info.setAddressId(request.getAddressId());
        info.setName(request.getFirstName()+" "+request.getLastName());
        info.setMail(request.getMail());
        logger.info(info.toString());
        Information saved=repo.save(info);
        InfoResponse resp=new InfoResponse(saved);
     //   resp.setAddress(addressF);
        return resp;
    }

    @Autowired
    AddressHttpExchange addressHttpExchange;

    @Override
    public InfoResponse getById(Long id) {
        logger.info("Get info by id ");
        return new InfoResponse(repo.findById(id).orElseGet(()->new Information()));
    }



    @Autowired
    AddressTransService service;
    @Value("${address.service.url}")
    String url;

    @CircuitBreaker(name = "addressService", fallbackMethod = "getAddressFallback")
    @Override
    @Retry(name = "addressService", fallbackMethod = "getAddressFallback")
    public AddressResponse getAddressById(Long id) {

        return service.transmit(url+"/api/address/"+id);
    }

    public  AddressResponse getAddressFallback(Long addId,Exception e){
        logger.info("Alert --> "+e);
        return new AddressResponse(0,"b","c");
    }

}
