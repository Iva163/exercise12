package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.FilmTitle;

import static org.mockito.Mockito.*;

public class PosterManagerMocTest {
    PosterRepository repo = Mockito.mock(PosterRepository.class);
    PosterManager manager = new PosterManager(repo);

    FilmTitle film1 = new FilmTitle(1, "Бладшот", "боевик");
    FilmTitle film2 = new FilmTitle(2, "Вперед", "мультфильм");
    FilmTitle film3 = new FilmTitle(3, "Джентельмены", "боевик");

    @BeforeEach
    public void setup() {
        FilmTitle[] films = {film1, film2, film3};
        doReturn(films).when(repo).findAll();
    }


    @Test
    public void shouldFindLast() {

        FilmTitle[] expected = {film3, film2, film1};
        FilmTitle[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastWithResultLength() {
        PosterManager manager1 = new PosterManager(2, repo);


        FilmTitle[] expected = {film3, film2};
        FilmTitle[] actual = manager1.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }


}
