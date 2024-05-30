package entity;

public enum SizeItem {
    XS,
    S,
    M,
    L,
    XL,
    XXL;

    @Override
    public String toString() {
        return switch (this){
            case XS -> "extra small";
            case S -> "small";
            case M -> "medium";
            case L -> "large";
            case XL -> "extra large";
            case XXL -> "extra extra large";
        };
    }
}
