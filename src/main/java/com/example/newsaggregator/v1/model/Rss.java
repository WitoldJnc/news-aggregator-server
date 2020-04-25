package com.example.newsaggregator.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Rss {
    //todo storage in db
    LENTA("lenta.ru", "http://lenta.ru/rss"),
    VESTI("vesti.ru", "https://www.vesti.ru/vesti.rss"),
    YANDEX_COVVID("yandex covid", "https://news.yandex.ru/koronavirus.rss"),
    YANDEX_MAIN("yandex main", "https://news.yandex.ru/index.rss"),
    YANDEX_WORLD("yandex in world", "https://news.yandex.ru/world.rss"),
    YADEX_INTERNET("yandex internet", "https://news.yandex.ru/internet.rss"),
    RAMBLER_WORLD("rambler in world", "https://news.rambler.ru/rss/world/"),
    TASS("tass.ru", "http://tass.ru/rss/v2.xml"),
    RIA("ria-ru", "https://ria.ru/export/rss2/index.xml"),
    WOMANS_RU_FORUM("woomans.ru", "http://www.woman.ru/forum/rss/"),
    GOROSKOP_FOR_DASHA("ГОРОСКОПИКИ НА НЕДЕЛЬКУ", "https://hyrax.ru/week/week.rss"),
    MORE_GOROSKOPS("Гороскоп тельца", "http://horo.tochka.net/rss/horoscopes/day/taurus/");

    private String resource;
    private String url;

    public static List<Rss> getAll() {
        return Arrays.asList(
                YANDEX_COVVID, YANDEX_MAIN, YANDEX_WORLD, YADEX_INTERNET,
                RAMBLER_WORLD, RIA,
                LENTA,
                VESTI,
                TASS,
                WOMANS_RU_FORUM, GOROSKOP_FOR_DASHA, MORE_GOROSKOPS
        );
    }


}
