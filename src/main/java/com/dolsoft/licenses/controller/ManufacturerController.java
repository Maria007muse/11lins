package com.dolsoft.licenses.controller;

import com.dolsoft.licenses.model.Manufacturer;
import com.dolsoft.licenses.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/manufacturer")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;
    @RequestMapping(value="/{manufacturerId}", method = RequestMethod.GET)
    public ResponseEntity<Manufacturer> getManufacturer(@PathVariable("manufacturerId") String manufacturerId) {
        Manufacturer manufacturer = manufacturerService.getManufacturer(manufacturerId);
        manufacturer.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ManufacturerController.class).getManufacturer(manufacturer.getManufacturerId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ManufacturerController.class).createManufacturer(manufacturer)).withRel("createManufacturer"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ManufacturerController.class).updateManufacturer(manufacturer)).withRel("updateManufacturer"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ManufacturerController.class).deleteManufacturer(manufacturer.getManufacturerId())).withRel("deleteManufacturer"));
        return ResponseEntity.ok(manufacturer);
    }
    @PutMapping
    public ResponseEntity<String> updateManufacturer(@RequestBody Manufacturer request) {
        return ResponseEntity.ok(manufacturerService.updateManufacturer(request));
    }
    @PostMapping
    public ResponseEntity<String> createManufacturer(@RequestBody Manufacturer request) {
        return ResponseEntity.ok(manufacturerService.createManufacturer(request));
    }
    @DeleteMapping(value="/{manufacturerId}")
    public ResponseEntity<String> deleteManufacturer(@PathVariable("manufacturerId") String manufacturerId) {
        return ResponseEntity.ok(manufacturerService.deleteManufacturer(manufacturerId));
    }
}

