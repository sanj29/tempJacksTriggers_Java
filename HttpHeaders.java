package com.codiscope.jaks.triggers.java.http;

import tests.sources.PrivateSource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * The class HttpHeaders
 */
public class HttpHeaders {
    private PrivateSource privateSource = new PrivateSource();

    /**
     * Test which should be found by Jacks
     */
    public void positiveHeadersTest(){
        String source = privateSource.method1();
        HttpServletResponse response = null;
        response.addHeader(source.replaceAll("\\p{C}", ""), source.replaceAll("\\p{C}", ""));
        response.setHeader(source.replaceAll("\\p{C}", ""), source.replaceAll("\\p{C}", ""));
    }

    /**
     * Test which should be found by Jacks
     */
    public void positiveCookieTest(){
        String source = privateSource.method1();
        Cookie cookie = new Cookie(source, source);
        cookie.setPath(source);
        cookie.setSecure(true);
        HttpServletResponse response = null;
        response.addCookie(cookie);
    }
}
