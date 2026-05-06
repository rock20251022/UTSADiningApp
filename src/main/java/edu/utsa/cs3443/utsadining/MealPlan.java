package edu.utsa.cs3443.utsadining;

public class MealPlan {
    private final String pageTitle;
    private final String planTitle;
    private final String price;
    private final String description;
    private final String included;
    private final String bestFor;

    public MealPlan(String pageTitle, String planTitle, String price,
                    String description, String included, String bestFor) {
        this.pageTitle = pageTitle;
        this.planTitle = planTitle;
        this.price = price;
        this.description = description;
        this.included = included;
        this.bestFor = bestFor;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getIncluded() {
        return included;
    }

    public String getBestFor() {
        return bestFor;
    }
}

