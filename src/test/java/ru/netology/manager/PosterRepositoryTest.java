package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmTitle;

public class PosterRepositoryTest {

    PosterRepository repo = new PosterRepository();

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

    @BeforeEach
    public void setup() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        repo.save(film7);
        repo.save(film8);
        repo.save(film9);
        repo.save(film10);
        repo.save(film11);
    }

    @Test
    public void shouldFindAll() {
        FilmTitle[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        FilmTitle[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        FilmTitle expected = film4;
        FilmTitle actual = repo.findById(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNull() {
        FilmTitle expected = null;
        FilmTitle actual = repo.findById(25);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repo.removeById(film5.getId());

        FilmTitle[] expected = {film1, film2, film3, film4, film6, film7, film8, film9, film10, film11};
        FilmTitle[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveByIdOver() {

        repo.removeById(25);

        FilmTitle[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        FilmTitle[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveAll() {

        repo.removeAll();
        FilmTitle[] expected = new FilmTitle[0];
        FilmTitle[] actual = repo.findAll();


        Assertions.assertArrayEquals(expected, actual);
    }

}
