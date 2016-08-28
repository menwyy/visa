package com.horbatiuk.visa;

import com.horbatiuk.visa.dataStorage.AllTravelAgencies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 11.08.2016.
 */
public class TravelAgency implements Serializable{
    private String travelAgencyName;
    private String travelAgencyEmail; //id
    private String getTravelAgencyWebSiteUrl;
    private String travelAgencyTelNumber;
    private String travelAgencyCity;
    private String travelAgencyStreet;
    private String travelAgencyHouseNumber;
    private List<String> respondsOfTravelAgency = new ArrayList<>();

    //Constructor

    public TravelAgency(String travelAgencyEmail, String travelAgencyName) {
        if(TravelAgencyUtils.checkTravelAgencyExistence(travelAgencyEmail)){
            throw new IllegalArgumentException("Travel agency with this email alreade exists.");
        }
        this.travelAgencyEmail = travelAgencyEmail; // email = id
        this.travelAgencyName = travelAgencyName;
        AllTravelAgencies.getAllTravelAgenciesMap().put(travelAgencyEmail,this); // Add itself to all travel agencies list
    }

    //Methods

    public String getTravelAgencyName() {
        return travelAgencyName;
    }

    public void setTravelAgencyName(String travelAgencyName) {
        this.travelAgencyName = travelAgencyName;
    }

    public String getTravelAgencyEmail() {
        return travelAgencyEmail;
    }

    public void setTravelAgencyEmail(String travelAgencyEmail) {
        this.travelAgencyEmail = travelAgencyEmail;
    }

    public String getGetTravelAgencyWebSiteUrl() {
        return getTravelAgencyWebSiteUrl;
    }

    public void setGetTravelAgencyWebSiteUrl(String getTravelAgencyWebSiteUrl) {
        this.getTravelAgencyWebSiteUrl = getTravelAgencyWebSiteUrl;
    }

    public String getTravelAgencyTelNumber() {
        return travelAgencyTelNumber;
    }

    public void setTravelAgencyTelNumber(String travelAgencyTelNumber) {
        this.travelAgencyTelNumber = travelAgencyTelNumber;
    }

    public String getTravelAgencyCity() {
        return travelAgencyCity;
    }

    public void setTravelAgencyCity(String travelAgencyCity) {
        this.travelAgencyCity = travelAgencyCity;
    }

    public String getTravelAgencyStreet() {
        return travelAgencyStreet;
    }

    public void setTravelAgencyStreet(String travelAgencyStreet) {
        this.travelAgencyStreet = travelAgencyStreet;
    }

    public String getTravelAgencyHouseNumber() {
        return travelAgencyHouseNumber;
    }

    public void setTravelAgencyHouseNumber(String travelAgencyHouseNumber) {
        this.travelAgencyHouseNumber = travelAgencyHouseNumber;
    }

    public List<String> getRespondsOfTravelAgency() {
        return respondsOfTravelAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelAgency that = (TravelAgency) o;

        if (travelAgencyHouseNumber != that.travelAgencyHouseNumber) return false;
        if (travelAgencyName != null ? !travelAgencyName.equals(that.travelAgencyName) : that.travelAgencyName != null)
            return false;
        if (getTravelAgencyWebSiteUrl != null ? !getTravelAgencyWebSiteUrl.equals(that.getTravelAgencyWebSiteUrl) : that.getTravelAgencyWebSiteUrl != null)
            return false;
        if (travelAgencyTelNumber != null ? !travelAgencyTelNumber.equals(that.travelAgencyTelNumber) : that.travelAgencyTelNumber != null)
            return false;
        if (travelAgencyCity != null ? !travelAgencyCity.equals(that.travelAgencyCity) : that.travelAgencyCity != null)
            return false;
        return travelAgencyStreet != null ? travelAgencyStreet.equals(that.travelAgencyStreet) : that.travelAgencyStreet == null;

    }

    @Override
    public int hashCode() {
        int result = travelAgencyName != null ? travelAgencyName.hashCode() : 0;
        result = 31 * result + (getTravelAgencyWebSiteUrl != null ? getTravelAgencyWebSiteUrl.hashCode() : 0);
        result = 31 * result + (travelAgencyTelNumber != null ? travelAgencyTelNumber.hashCode() : 0);
        result = 31 * result + (travelAgencyCity != null ? travelAgencyCity.hashCode() : 0);
        result = 31 * result + (travelAgencyStreet != null ? travelAgencyStreet.hashCode() : 0);
        result = 31 * result + (travelAgencyHouseNumber != null ? travelAgencyHouseNumber.hashCode() : 0);
        return result;
    }
}
