package ru.netology.manager;

import ru.netology.domain.FilmTitle;

public class PosterManager {

    private int maxFilmsLast = 10;
    private FilmTitle[] films = new FilmTitle[0];

    public PosterManager() {
    }

    public PosterManager(int maxFilmsLast) {
        this.maxFilmsLast = maxFilmsLast;
    }

    public void add(FilmTitle film) {
        FilmTitle[] tmp = new FilmTitle[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public FilmTitle[] findAll() {
        return films;
    }

    public FilmTitle[] findLast() {
        int resultLength = maxFilmsLast;
        if (films.length < resultLength) {
            resultLength = films.length;
        }
        FilmTitle[] result = new FilmTitle[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }


}
