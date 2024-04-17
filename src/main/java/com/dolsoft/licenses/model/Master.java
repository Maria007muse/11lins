package com.dolsoft.licenses.model;

import jakarta.persistence.*;
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
public class Master extends RepresentationModel<Master> implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    private String masterId;
    private String fullName;
    private String position;
    private String phone;
    private String comment;
}