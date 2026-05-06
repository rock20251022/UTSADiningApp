package edu.utsa.cs3443.utsadining;

public class AboutSection {
    private final String pageTitle;
    private final String heading;
    private final String intro;
    private final String focusPoints;
    private final String whyItMatters;

    public AboutSection(String pageTitle, String heading, String intro,
                        String focusPoints, String whyItMatters) {
        this.pageTitle = pageTitle;
        this.heading = heading;
        this.intro = intro;
        this.focusPoints = focusPoints;
        this.whyItMatters = whyItMatters;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getHeading() {
        return heading;
    }

    public String getIntro() {
        return intro;
    }

    public String getFocusPoints() {
        return focusPoints;
    }

    public String getWhyItMatters() {
        return whyItMatters;
    }
}