package week_5.assignment_problems;

public final class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("roomNumber cannot be blank");
        }
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public ReferenceOnlyLoanReceipt withCorrectedBookId(int index, String newId) {
        String[] correctedIds = getBookIds();

        if (index < 0 || index >= correctedIds.length) {
            throw new IndexOutOfBoundsException("Invalid book index: " + index);
        }
        if (newId == null || newId.trim().isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be blank");
        }

        correctedIds[index] = newId;
        return new ReferenceOnlyLoanReceipt(getMemberId(), correctedIds, roomNumber);
    }
}