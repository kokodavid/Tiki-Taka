package com.example.tiki_taka;

public class Event {
    private String mName;
    private String mDescription;
    private String mStart;
    private String mEnd;

    public Event(String Name,String Description,String Start,String End){
        this.mName = Name;
        this.mDescription = Description;
        this.mStart = Start;
        this.mEnd = End;


    }
    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getStart() {
        return  mStart;
    }

    public String getEnd() {  return mEnd;  }
}
