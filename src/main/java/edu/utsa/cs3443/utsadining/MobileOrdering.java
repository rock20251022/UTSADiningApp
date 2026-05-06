package edu.utsa.cs3443.utsadining;


public class MobileOrdering {

    private String appName;
    private String[] steps;

    public MobileOrdering() {
        appName = "GrubHub";
        steps = new String[]{
                "Download GrubHub app and create a new account. If you have an account sign in.",
                "Go to Account and click Campus Dining.",
                "Select your campus and choose your affiliation.",
                "Add your UTSACard to pay with Dining Dollars or Meal Trades.",
                "Order ahead and skip the line! Grab your meal to-go across campus."
        };
    }

    public String getAppName() { return appName; }
    public String[] getSteps() { return steps; }
}