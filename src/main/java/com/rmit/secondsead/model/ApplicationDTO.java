package com.rmit.secondsead.model;

public class ApplicationDTO {
    private  Long eID;

    private Long aID;

    public ApplicationDTO(){

    }

    @Override
    public String toString() {
        return "ApplicationDTO{" +
                "eID=" + eID +
                ", aID=" + aID +
                '}';
    }
}
