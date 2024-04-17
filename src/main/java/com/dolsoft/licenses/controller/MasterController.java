package com.dolsoft.licenses.controller;

import com.dolsoft.licenses.model.Master;
import com.dolsoft.licenses.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value="v1/master")
public class MasterController {
    @Autowired
    private MasterService masterService;
    @RequestMapping(value="/{masterId}", method = RequestMethod.GET)
    public ResponseEntity<Master> getMaster(@PathVariable("masterId") String masterId) {
        Master master = masterService.getMaster(masterId);
        master.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MasterController.class).getMaster(master.getMasterId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MasterController.class).createMaster(master)).withRel("createMaster"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MasterController.class).updateMaster(master)).withRel("updateMaster"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MasterController.class).deleteMaster(master.getMasterId())).withRel("deleteMaster"));
        return ResponseEntity.ok(master);
    }
    @PutMapping
    public ResponseEntity<String> updateMaster(@RequestBody Master request) {
        return ResponseEntity.ok(masterService.updateMaster(request));
    }
    @PostMapping
    public ResponseEntity<String> createMaster(@RequestBody Master request) {
        return ResponseEntity.ok(masterService.createMaster(request));
    }
    @DeleteMapping(value="/{masterId}")
    public ResponseEntity<String> deleteMaster(@PathVariable("masterId") String masterId) {
        return ResponseEntity.ok(masterService.deleteMaster(masterId));
    }
}
