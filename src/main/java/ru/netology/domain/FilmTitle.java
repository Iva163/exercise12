package ru.netology.domain;

public class FilmTitle {
    private int id;
    private String filmName;
    private String filmGenre;

    public FilmTitle(int id, String filmName, String filmGenre) {
        this.id = id;
        this.filmName = filmName;
        this.filmGenre = filmGenre;
    }

    public int getId() {
        return id;
    }
}
