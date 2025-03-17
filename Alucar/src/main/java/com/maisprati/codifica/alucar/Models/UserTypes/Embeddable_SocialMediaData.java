package com.maisprati.codifica.alucar.Models.UserTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Embeddable_SocialMediaData {

    public Embeddable_SocialMediaData(){
        this.location = " ";
        this.instagram = " ";
    }

    @Column/*(nullable = true)*/
    protected String location;

    @Column/*(nullable = true)*/
    protected String instagram;


}
