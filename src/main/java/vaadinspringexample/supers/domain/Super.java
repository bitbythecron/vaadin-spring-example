package vaadinspringexample.supers.domain;

import java.util.EnumSet;

public class Super {
    private String nickname;
    private SuperType superType;
    private EnumSet<Power> powers;

    public Super() {
        this(null, null);
    }

    public Super(String nickname, SuperType superType) {
        this.nickname = nickname;
        this.superType = superType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public SuperType getSuperType() {
        return superType;
    }

    public void setSuperType(SuperType superType) {
        this.superType = superType;
    }

    public EnumSet<Power> getPowers() {
        return powers;
    }

    public void setPowers(EnumSet<Power> powers) {
        this.powers = powers;
    }
}
