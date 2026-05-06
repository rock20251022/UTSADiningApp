package edu.utsa.cs3443.utsadining;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EventDetails {

    private List<Event> events;

    public EventDetails() {
        events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void loadEventsFromFile(String fileName) {
        events.clear();
        try {
            InputStream is = getClass().getResourceAsStream(
                    "/data/" + fileName);
            if (is == null) {
                System.err.println("Could not find resource: " + fileName);
                return;
            }
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = splitCSV(line);
                if (parts.length < 6) continue;

                events.add(new Event(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim(),
                        parts[4].trim(),
                        parts[5].trim()
                ));
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Event getEventByTitle(String title) {
        for (Event e : events) {
            if (e.getTitle().equalsIgnoreCase(title)) {
                return e;
            }
        }
        return null;
    }

    private String[] splitCSV(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                tokens.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        tokens.add(sb.toString());
        return tokens.toArray(new String[0]);
    }
}
