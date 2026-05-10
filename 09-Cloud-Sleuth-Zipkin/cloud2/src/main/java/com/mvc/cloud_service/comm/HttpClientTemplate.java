package com.mvc.cloud_service.comm;

import com.mvc.cloud_service.dto.AddressResponse;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HttpClientTemplate implements AddressTransService{

   private static final  HttpClient client=HttpClient.newHttpClient();

   public AddressResponse transmit(String url){
       HttpRequest request=HttpRequest.newBuilder()
               .uri(URI.create(url))
               .build();
     try{
         HttpResponse<String> response = client.send(
                 request,
                 HttpResponse.BodyHandlers.ofString()
         );

         System.out.println(response.body().toString());
         ObjectMapper mapper=new ObjectMapper();
         return mapper.readValue(response.body(), AddressResponse.class);
     }
     catch (Exception e){
         e.printStackTrace();
     }
     finally {
         System.out.println(" HTTP call made ....");
     }
       return new AddressResponse();
   }

}
