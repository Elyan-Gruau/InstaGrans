package com.granny.grannyService.granny;

public class Dish {
    private String name;
    private String prepTime;


    private int prepMinute;
    private String note;
    private String urlImage;

    public Dish(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
        this.urlImage =normalize(name)+".png";
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

    public int getPrepMinute() {
        return prepMinute;
    }

    public void setPrepMinute(int prepMinute) {
        this.prepMinute = prepMinute;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    private String normalize(String s){
        s = s.toLowerCase();
        s= s.replaceAll("é","e");
        s= s.replaceAll("è","e");
        s= s.replaceAll("ê","e");
        s= s.replaceAll("ë","e");

        s= s.replaceAll("ä","a");
        s= s.replaceAll("â","a");

        s= s.replaceAll("î","i");
        s= s.replaceAll("ï","i");

        s= s.replaceAll("ô","o");
        s= s.replaceAll("ö","o");

        s= s.replaceAll("à","a");

        s= s.replaceAll("û","u");
        s= s.replaceAll("ü","u");
        s= s.replaceAll("ù","u");


        s= s.replaceAll(" ","_");
        s= s.replaceAll("'","_");
        return s;
    }
}
