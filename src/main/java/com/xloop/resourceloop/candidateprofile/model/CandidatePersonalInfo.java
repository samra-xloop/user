package com.xloop.resourceloop.candidateprofile.model;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "candidate_personal_information")
public class CandidatePersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;
    private String nationalIdentityNumber;
    private String phoneNumber;
    private String city;
    private String address;
    private String linkedProfile;
    private String maritalStatus;

    public CandidatePersonalInfo(String firstName, String lastName, Date dateOfBirth, String gender,
            String nationalIdentityNumber, String phoneNumber, String city, String address, String linkedProfile,
            String maritalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationalIdentityNumber = nationalIdentityNumber;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.address = address;
        this.linkedProfile = linkedProfile;
        this.maritalStatus = maritalStatus;
    }

    public CandidatePersonalInfo(){};

    
}
