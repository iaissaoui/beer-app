package com.example.demo.model;

import com.example.demo.utils.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;
import java.time.LocalDate;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Beer {

    @Id
    private Long id;
    private String name;
    private String tagline;
    @Column(columnDefinition = "DATE")
    @JsonProperty("first_brewed")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate firstBrewed;
    @Column(columnDefinition = "TEXT")
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    private Double abv;


    @Override
    public boolean equals(Object o){
        if(!(o instanceof Beer) ){
            return false;
        }
        Beer otherBeer = (Beer) o;
        return this.id.equals(otherBeer.getId());
    }
    @Override
    public int hashCode(){
        return id.hashCode();
    }

}
