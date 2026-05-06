package edu.utsa.cs3443.utsadining;

public class Event {

    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private String imagePath;

    public Event(String title, String date, String time, String location,
                 String description, String imagePath) {
        this.title       = title;
        this.date        = date;
        this.time        = time;
        this.location    = location;
        this.description = description;
        this.imagePath   = imagePath;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
