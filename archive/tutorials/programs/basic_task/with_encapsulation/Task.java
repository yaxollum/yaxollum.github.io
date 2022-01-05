public class Task {
    public Task() {
        name = "default";
        duration = 300;
        priority = 3;
        percentageComplete = 0;
    }

    private String name;
    private int duration; // time required in seconds
    private int priority; // on a scale from 1 to 10, 1 being the highest priority
    private double percentageComplete;

    public void extendDuration(int extensionAmount) {
        duration += extensionAmount;
    }

    public void bumpPriority() {
        --priority;
    }

    public void updateCompletion(double percentageIncrease) {
        percentageComplete += percentageIncrease;
        if (percentageComplete > 100) {
            percentageComplete = 100;
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getPriority() {
        return priority;
    }

    public double getPercentage() {
        return percentageComplete;
    }
}
