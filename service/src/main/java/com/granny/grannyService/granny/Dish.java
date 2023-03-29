package com.granny.grannyService.granny;

public class Dish {
    private String name;
    private String prepTime;
    private String note;
    private String urlImage;

    public Dish(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
        this.urlImage = name+".png";
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrlImage() {
        return urlImage;
    }


}
