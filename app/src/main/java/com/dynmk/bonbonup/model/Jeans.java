package com.dynmk.bonbonup.model;

public class Jeans {
    private String titulo, thumbnailUrl, thumbnailUrl2, thumbnailUrl3;
    private int ref;
    private String marca;
    private String color;
    private String tipo;



    public Jeans() {
    }

    public Jeans(String name, String thumbnailUrl, String thumbnailUrl2, String thumbnailUrl3, int ref, String marca, String color, String tipo) {
        this.titulo = name;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailUrl2 = thumbnailUrl2;
        this.thumbnailUrl3 = thumbnailUrl3;
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

    public String getThumbnailUrl2() {
        return thumbnailUrl2;
    }

    public void setThumbnailUrl2(String thumbnailUrl2) {
        this.thumbnailUrl2 = thumbnailUrl2;
    }

    public String getThumbnailUrl3() {
        return thumbnailUrl3;
    }

    public void setThumbnailUrl3(String thumbnailUrl3) {
        this.thumbnailUrl3 = thumbnailUrl3;
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
