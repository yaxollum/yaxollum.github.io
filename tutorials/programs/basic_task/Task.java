public class Task {
    String name;
    int duration; // time required in seconds
    int priority; // on a scale from 1 to 10, 1 being the highest priority
    double percentageComplete;

    void extendDuration(int extensionAmount) {
        duration+=extensionAmount;
    }

    void bumpPriority() {
        --priority;
    }

    void updateCompletion(double percentageIncrease) {
        percentageComplete+=percentageIncrease;
        if(percentageComplete>100) {
            percentageComplete=100;
        }
    }
}
