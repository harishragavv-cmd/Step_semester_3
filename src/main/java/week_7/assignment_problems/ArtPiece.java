package week_7.assignment_problems;

public abstract class ArtPiece {
    private static int nextId = 1000;

    private final String pieceId;
    protected final String title;

    public ArtPiece(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("title cannot be blank");
        }

        this.title = title;
        nextId++;
        this.pieceId = "ART-" + nextId;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}