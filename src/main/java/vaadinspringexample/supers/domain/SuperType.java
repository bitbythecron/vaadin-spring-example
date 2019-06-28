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
}
