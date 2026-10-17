package week_5.assignment_problems;

 /*
  * Specification conflict: this assignment requests LoanReceipt to be final
  * and also requires ReferenceOnlyLoanReceipt to extend it. Java cannot do
  * both, because a final class cannot be subclassed. This class is therefore
  * non-final so the required inheritance and instanceof dispatch compile.
  * Its own fields remain final and its array is defensively copied.
  */
public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        if (memberId == null || bookIds == null) {
            throw new IllegalArgumentException("memberId and bookIds cannot be null");
        }
        if (bookIds.length > 20) {
            throw new IllegalArgumentException("A receipt can contain at most 20 book IDs");
        }

        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= bookIds.length) {
            throw new IndexOutOfBoundsException("Invalid book index: " + index);
        }
        if (newId == null || newId.trim().isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be blank");
        }

        String[] correctedIds = bookIds.clone();
        correctedIds[index] = newId;
        return new LoanReceipt(memberId, correctedIds);
    }
}