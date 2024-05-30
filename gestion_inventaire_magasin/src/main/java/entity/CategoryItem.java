package entity;

public enum CategoryItem {
    MAN,
    WOMAN,
    CHILDREN;

    @Override
    public String toString() {
        return switch (this) {
            case MAN -> "Man";
            case WOMAN -> "Woman";
            case CHILDREN -> "Children";
        };
    }
}
