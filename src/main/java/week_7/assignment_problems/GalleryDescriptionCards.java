package week_7.assignment_problems;

public class GalleryDescriptionCards {
    public static void main(String[] args) {
        Painting painting = new Painting("Sunset Fields");
        Sculpture sculpture = new Sculpture("The Thinker II");

        System.out.println(painting.describe());
        System.out.println(sculpture.describe());
        System.out.println(painting.getPieceId());
        System.out.println(sculpture.getPieceId());

        // ArtPiece is abstract, so new ArtPiece(...) cannot compile.
    }
}