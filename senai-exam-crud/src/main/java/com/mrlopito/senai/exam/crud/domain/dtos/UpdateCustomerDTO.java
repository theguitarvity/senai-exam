package com.mrlopito.senai.exam.crud.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public class UpdateCustomerDTO {

    @NotBlank(message = "Name must be provided")
    private String name;
    @NotBlank(message = "Email must be provided")
    private String email;
    @NotBlank(message = "Document must be provided")
    private String document;
    @NotBlank(message = "Address must be provided")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
