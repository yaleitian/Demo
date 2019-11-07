package com.springmvc.service.impl;

import com.springmvc.service.CompactDisc;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
    private String title = "stg";
    private String artist = "The Beatles";
    public void play() {
        System.out.println("Playing " + title + "by " + artist);
    }
}
