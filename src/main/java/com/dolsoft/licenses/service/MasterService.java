package com.dolsoft.licenses.service;

import com.dolsoft.licenses.model.Master;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MasterService{
    public Master getMaster(String masterId) {
        Master master = new Master();
        master.setId(new Random().nextInt(1000));
        master.setMasterId(masterId);
        master.setFullName("Some Service");
        master.setPosition("Some pos");
        master.setComment("Comment");
        master.setPhone("876547563487");
        return master;
    }

    public String createMaster(Master master) {
        String responseMessage = null;
        if(master != null) {
            responseMessage = String.format("This is the post and the object is: %s",master.toString());
        }
        return responseMessage;
    }

    public String updateMaster(Master master) {
        String responseMessage = null;
        if (master != null) {
            responseMessage = String.format("This is the put and the object is: %s", master.toString());
        }
        return responseMessage;
    }

    public String deleteMaster(String masterId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting master with id %s", masterId);
        return responseMessage;
    }
}