package com.example.NameSelect.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class NameRatingKey implements Serializable {

    @Column(name = "id_username2")
    Long userId;

    @Column(name = "id_im2")
    Long nameId;
}
