package entity;

public enum SaleState {
    IN_PROGRESS,
    COMPLETED,
    CANCELLED,;

    @Override
    public String toString() {
        return switch (this){
            case IN_PROGRESS -> "IN PROGRESS";
            case COMPLETED -> "COMPLETED";
            case CANCELLED -> "CANCELLED";
        };
    }
}
