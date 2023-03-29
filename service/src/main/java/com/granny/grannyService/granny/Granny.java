package com.granny.grannyService.granny;


import java.util.ArrayList;

public class Granny {
    private String name;
    private int age;
    private ArrayList<Dish> dishes = new ArrayList<>();
    private String desc;
    private String location;
    private double price;
    private String urlPicture;
    private double score;


    public Granny(){

    }
    public Granny(String name, int age, ArrayList<Dish> dishes){
        this.name = name;
        this.age = age;
        this.dishes = dishes;
    }

    public boolean hasDish(Dish dish){
        if (dishes.size()>0){

        }
        for (Dish d:dishes){
            if (d.getName().equals(dish.getName())){
                return true;
            }
        }
        return false;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public int getAge() {
        return age;
    }

    public void setDishes(ArrayList<Dish> newDishes) {
        if (dishes.size() == 0){
            this.dishes.add(newDishes.get(0));
        }
        for (Dish d : newDishes){
            if (!hasDish(d)){
                this.dishes.add(d);
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public void addDish(Dish d){
        this.dishes.add(d);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
