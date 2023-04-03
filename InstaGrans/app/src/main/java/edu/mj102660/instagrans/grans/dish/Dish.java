package edu.mj102660.instagrans.grans.dish;

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

    public int getPrepMinute() {
        return prepMinute;
    }

    public void setPrepMinute(int prepMinute) {
        this.prepMinute = prepMinute;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
