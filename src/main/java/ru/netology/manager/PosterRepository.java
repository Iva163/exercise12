package ru.netology.manager;

import ru.netology.domain.FilmTitle;

public class PosterRepository {

    private FilmTitle[] films = new FilmTitle[0];

    public void save(FilmTitle film) {
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

    public FilmTitle findById(int id) {
        for (FilmTitle film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        boolean test = false;

        for (FilmTitle film : films) {
            if (film.getId() == id) {
                test = true;
            }
        }

        if (test == false) {
            return;
        }


        FilmTitle[] tmp = new FilmTitle[films.length - 1];
        int copyIndex = 0;
        for (FilmTitle film : films) {
            if (film.getId() != id) {
                tmp[copyIndex] = film;
                copyIndex++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        FilmTitle[] tmp = new FilmTitle[0];
        films = tmp;
    }


}
