package vaadinspringexample.supers.domain;

public enum Power {
    FLYING("Flying"),
    INVISIBILITY("Invisibility"),
    SUPER_STRENGTH("Super Strength"),
    SUPER_SPEED("Super Speed"),
    FAST_HEALING("Fast Healing"),
    PYROTECHNICS("Pyrotechnics"),
    CRYOTECHNICS("Cryotechnics"),
    ELECTROTECHNICS("Electrotechnics");

    private String label;

    private Power(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
