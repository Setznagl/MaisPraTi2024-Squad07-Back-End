package com.maisprati.codifica.alucar.Models.UserTypes;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("renter")
public class RenterUser extends RawUser{
    protected RenterUser(){/*Empty constructor*/}
    /**
     * Inherited by de RawUser:
     *      private String cpf;
     *      private String name;
     *      private java.sql.Date birthdate;
     *      private String phone;
     *      private String email;
     *      private String password;
     *      private Integer average_rating;
     *      private java.sql.Timestamp created_at;
     *      private byte[] photo;
     */
    public RenterUser(String parameter_name , String parameter_email , String parameter_password) {
        super(parameter_name , parameter_email , parameter_password);
        /*
         * Prevent NullPointerException
         */
        this.socialMediaData = new Embeddable_SocialMediaData();
    }

    private Embeddable_SocialMediaData socialMediaData;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getLocation(){return socialMediaData.location;}
    public void setLocation(String location){this.socialMediaData.location = location;}

    public String getInstagram(){return socialMediaData.instagram;}
    public void setInstagram(String instagram){this.socialMediaData.instagram = instagram;}
}
