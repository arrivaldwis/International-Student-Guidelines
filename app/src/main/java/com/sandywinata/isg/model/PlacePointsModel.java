package com.sandywinata.isg.model;

public class PlacePointsModel {
    public Double latitude;
    public Double longitude;
    public String place;

    public PlacePointsModel() {
    }

    public PlacePointsModel(Double latitude, Double longitude, String place) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.place = place;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
