package com.dolsoft.licenses.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class Manufacturer extends RepresentationModel<Manufacturer> implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    private String manufacturerId;
    private String name;
    private String country;
    private String contactPerson;
    private String phone;
}

