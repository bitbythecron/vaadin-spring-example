package vaadinspringexample.supers.domain;

public enum SuperType {
    HERO("Hero"),
    VILLAIN("Villain");

    private String label;

    private SuperType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static SuperType lookup(String label) {

        for (SuperType superType : values()) {
            if (superType.label.equals(label)) {
                return superType;
            }
        }

        return null;

    }
}
