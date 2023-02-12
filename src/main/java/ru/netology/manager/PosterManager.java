package ru.netology.manager;

import ru.netology.domain.FilmTitle;

public class PosterManager {

    private int maxFilmsLast = 10;
    private PosterRepository repo;

    public PosterManager(PosterRepository repo) {
        this.repo = repo;
    }

    public PosterManager(int maxFilmsLast, PosterRepository repo) {
        this.maxFilmsLast = maxFilmsLast;
        this.repo = repo;
    }


    public void add(FilmTitle film) {
        repo.save(film);
    }

    public FilmTitle[] findAll() {
        return repo.findAll();

    }

    public FilmTitle[] findLast() {
        int resultLength = maxFilmsLast;
        FilmTitle[] all = repo.findAll();

        if (all.length < resultLength) {
            resultLength = all.length;
        }
        FilmTitle[] result = new FilmTitle[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = all[all.length - 1 - i];
        }
        return result;
    }


}
