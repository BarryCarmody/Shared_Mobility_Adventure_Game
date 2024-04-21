package Game;

public class Level {
    private int levelNumber;
    private int totalGems;
    private int collectedGems;
    private int levelTimeLimit; // Assuming seconds for simplicity
    private boolean isActive;

    public Level(int levelNumber, int totalGems, int levelTimeLimit) {
        this.levelNumber = levelNumber;
        this.totalGems = totalGems;
        this.levelTimeLimit = levelTimeLimit;
        this.collectedGems = 0;
        this.isActive = false;
    }

    public void startLevel() {
        collectedGems = 0;
        isActive = true;
        // Initialize or reset any other level-specific settings
    }

    public void completeLevel() {
        isActive = false;
        // Handle level completion logic, such as saving scores or transitioning to another level
    }

    public void incrementGemCount() {
        if (isActive && collectedGems < totalGems) {
            collectedGems++;
        }
        if (collectedGems == totalGems) {
            completeLevel();
        }
    }

    public boolean isLevelComplete() {
        return collectedGems >= totalGems;
    }

    public int getRemainingGems() {
        return totalGems - collectedGems;
    }

}
