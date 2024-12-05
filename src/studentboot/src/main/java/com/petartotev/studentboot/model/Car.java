package com.petartotev.studentboot.model;

public class Car {
    private Long id;
    private String brand;
    private String model;
    private Color color;
    private int year;

    public enum Color { WHITE, BLACK, RED, GREEN, BLUE, CYAN, MAGENTA, YELLOW }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
