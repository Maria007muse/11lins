package com.dolsoft.licenses.service;

import com.dolsoft.licenses.model.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ManufacturerService {
    public Manufacturer getManufacturer(String manufacturerId) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(new Random().nextInt(1000));
        manufacturer.setManufacturerId(manufacturerId);
        manufacturer.setName("Some Manufacturer");
        manufacturer.setCountry("Some country");
        manufacturer.setContactPerson("Some contact person");
        manufacturer.setPhone("876547563487");
        return manufacturer;
    }
    public String createManufacturer(Manufacturer manufacturer) {
        String responseMessage = null;
        if(manufacturer != null) {
            responseMessage = String.format("This is the post and the object is: %s", manufacturer.toString());
        }
        return responseMessage;
    }
    public String updateManufacturer(Manufacturer manufacturer) {
        String responseMessage = null;
        if (manufacturer != null) {
            responseMessage = String.format("This is the put and the object is: %s", manufacturer.toString());
        }
        return responseMessage;
    }
    public String deleteManufacturer(String manufacturerId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting manufacturer with id %s", manufacturerId);
        return responseMessage;
    }
}

