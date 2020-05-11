package com.newsaggregator.web.impl.v2.rss;

import com.newsaggregator.web.service.v2.rss.UrlValidatorService;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class UrlValodatorServiceImpl implements UrlValidatorService {

    @Override
    public boolean isValid(String url) {
        try {
            URL curUrl = new URL(url);
            HttpURLConnection con = (HttpURLConnection) curUrl.openConnection();
            return con.getResponseCode() < 400;
        } catch (Exception e) {
            return false;
        }
    }
}
