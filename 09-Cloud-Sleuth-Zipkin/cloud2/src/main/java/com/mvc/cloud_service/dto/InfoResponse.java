package com.mvc.cloud_service.dto;

import com.mvc.cloud_service.entity.Information;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class InfoResponse {
    private long id;
    private String name;
    private String mail;
    private AddressResponse address;

    public InfoResponse(Information info){
        this.address.setAddressId(info.getAddressId());
        this.id=info.getId();
        this.name=info.getName();
        this.mail=info.getMail();
    }
}
