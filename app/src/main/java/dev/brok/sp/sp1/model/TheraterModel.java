package dev.brok.sp.sp1.model;

/**
 * Created by kaungkhantlynn on 7/31/16.
 */
public class TheraterModel {
    int id;
    String name;
    String description;
    String phone;
    int img;

    public TheraterModel(int id, String name, String description, String phone, int img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public int getImg() {
        return img;
    }
}
