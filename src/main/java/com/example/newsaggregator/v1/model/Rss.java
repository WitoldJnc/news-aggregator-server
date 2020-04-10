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
    RIA("ria-ru", "https://ria.ru/export/rss2/index.xml");

    private String resource;
    private String url;

    public static List<Rss> getAll() {
        return Arrays.asList(
                YANDEX_COVVID, YANDEX_MAIN, YANDEX_WORLD, YADEX_INTERNET,
                RAMBLER_WORLD, RIA,
                LENTA,
                VESTI,
                TASS
        );
    }


}
