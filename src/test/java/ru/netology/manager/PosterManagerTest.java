package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmTitle;

public class PosterManagerTest {

    FilmTitle film1 = new FilmTitle(1, "Бладшот", "боевик");
    FilmTitle film2 = new FilmTitle(2, "Вперед", "мультфильм");
    FilmTitle film3 = new FilmTitle(3, "Джентельмены", "боевик");
    FilmTitle film4 = new FilmTitle(4, "Фильм4", "комедия");
    FilmTitle film5 = new FilmTitle(5, "Фильм5", "мультфильм");
    FilmTitle film6 = new FilmTitle(6, "Фильм6", "боевик");
    FilmTitle film7 = new FilmTitle(7, "Фильм7", "боевик");
    FilmTitle film8 = new FilmTitle(8, "Фильм8", "мультфильм");
    FilmTitle film9 = new FilmTitle(9, "Фильм9", "боевик");
    FilmTitle film10 = new FilmTitle(10, "Фильм10", "боевик");
    FilmTitle film11 = new FilmTitle(11, "Фильм11", "мультфильм");


    @Test
    public void shouldFindAll() {
        PosterManager film = new PosterManager();
        film.add(film1);
        film.add(film2);
        film.add(film3);


        FilmTitle[] expected = {film1, film2, film3};
        FilmTitle[] actual = film.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        PosterManager film = new PosterManager();
        film.add(film1);
        film.add(film2);
        film.add(film3);


        FilmTitle[] expected = {film3, film2, film1};
        FilmTitle[] actual = film.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddOverResult() {
        PosterManager film = new PosterManager();
        film.add(film1);
        film.add(film2);
        film.add(film3);
        film.add(film4);
        film.add(film5);
        film.add(film6);
        film.add(film7);
        film.add(film8);
        film.add(film9);
        film.add(film10);
        film.add(film11);


        FilmTitle[] expected = {film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        FilmTitle[] actual = film.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithResultLength() {
        PosterManager film = new PosterManager(2);
        film.add(film1);
        film.add(film2);
        film.add(film3);


        FilmTitle[] expected = {film3, film2};
        FilmTitle[] actual = film.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithResultLengthEqItems() {
        PosterManager film = new PosterManager(3);
        film.add(film1);
        film.add(film2);
        film.add(film3);


        FilmTitle[] expected = {film3, film2, film1};
        FilmTitle[] actual = film.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithResultLengthOverItems() {
        PosterManager film = new PosterManager(5);
        film.add(film1);
        film.add(film2);
        film.add(film3);


        FilmTitle[] expected = {film3, film2, film1};
        FilmTitle[] actual = film.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
