/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author JRS
 */
public class event {

    private int id;
    private String name;
    private String description;
    private Date date;
    private String address;
    private int postalCode;
    private double price;
    private int room;
    private int placeId;

    public event(int id, String name, String description, Date date, String address, int postalCode, double price, int room, int placeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.address = address;
        this.postalCode = postalCode;
        this.price = price;
        this.room = room;
        this.placeId = placeId;
    }

    public event(String name, String description, Date date, String address, int postalCode, double price, int room, int placeId) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.address = address;
        this.postalCode = postalCode;
        this.price = price;
        this.room = room;
        this.placeId = placeId;
    }

    public event() {

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the postalCode
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the room
     */
    public int getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(int room) {
        this.room = room;
    }

    /**
     * @return the placeId
     */
    public int getPlaceId() {
        return placeId;
    }

    /**
     * @param placeId the placeId to set
     */
    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
}
