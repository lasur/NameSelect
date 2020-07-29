package com.example.NameSelect.model;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Data
@Table(name="id_table2")
public class NameRating {

    @EmbeddedId
    NameRatingKey id;

    @ManyToOne
    @MapsId("id_username2")
    @JoinColumn(name = "id_username2")
    User user;

    @ManyToOne
    @MapsId("id_im2")
    @JoinColumn(name = "id_im2")
    Name name;

    @Column(name = "note")
    int rating;
}