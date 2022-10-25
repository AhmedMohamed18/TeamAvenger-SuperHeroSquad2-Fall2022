/*
 * @author of Class: Cameron Lake
 *
 * */
class Puzzle {
    private int puzzleId;
    private String description;
    private String answer;
    private String hint;
    private int room;
    private String difficulty;

    public Puzzle(int puzzleId, String description, String answer, String hint, int room, String difficulty) {
        super();
        this.puzzleId = puzzleId;
        this.description = description;
        this.answer = answer;
        this.hint = hint;
        this.room = room;
        this.difficulty = difficulty;
    }

    public int getPuzzleId() {
        return puzzleId;
    }

    public void setPuzzleId(int puzzleId) {
        this.puzzleId = puzzleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}

