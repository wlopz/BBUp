package com.dynmk.bonbonup.model;


public class Blusas {
    private String titulo, thumbnailUrl;
    private int ref;
    private String marca;
    private String color;
    private String tipo;



    public Blusas() {
    }

    public Blusas(String name, String thumbnailUrl, int ref, String marca, String color, String tipo) {
        this.titulo = name;
        this.thumbnailUrl = thumbnailUrl;
        this.ref = ref;
        this.marca = marca;
        this.color = color;
        this.tipo = tipo;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String name) {
        this.titulo = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
