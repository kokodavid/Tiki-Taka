package com.example.tiki_taka;

public class Event {
    private String Name;
    private String Description;
    private String Start;
    private String End;
    private String url;

    public Event(String name, String description, String start, String end, String url) {
        Name = name;
        Description = description;
        Start = start;
        End = end;
        this.url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
