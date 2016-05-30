package com.example.evgeniy.yaltask3.data.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Evgeniy
 */
public class Address extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    private long id;

    @SerializedName("district")
    private District district;

    @SerializedName("city")
    private City city;

    @SerializedName("street")
    private Street street;

    @SerializedName("house")
    private House house;

    @SerializedName("flat")
    private String flat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }


}
