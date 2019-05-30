package com.example.tiki_taka.ui;

import org.parceler.Parcel;

@Parcel
public class Event {
    String name;
    String description;
    String start;
    String end;
    String url;

    public Event() {}

    public Event(String name, String description, String start, String end, String url) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
