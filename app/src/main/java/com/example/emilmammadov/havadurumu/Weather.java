package com.example.emilmammadov.havadurumu;

public class Weather {
    private String cityWeather;
    private String tempWeather;
    private int imgIdWeather;

    public Weather(String cityWeather, String tempWeather, int imgIdWeather) {
        this.setCityWeather(cityWeather);
        this.setTempWeather(tempWeather);
        this.setImgIdWeather(imgIdWeather);
    }

    public String getCityWeather() {
        return cityWeather;
    }

    public void setCityWeather(String cityWeather) {
        this.cityWeather = cityWeather;
    }

    public String getTempWeather() {
        return tempWeather;
    }

    public void setTempWeather(String tempWeather) {
        this.tempWeather = tempWeather;
    }

    public int getImgIdWeather() {
        return imgIdWeather;
    }

    public void setImgIdWeather(int imgIdWeather) {
        this.imgIdWeather = imgIdWeather;
    }
}