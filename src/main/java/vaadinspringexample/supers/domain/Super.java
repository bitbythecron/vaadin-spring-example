package vaadinspringexample.supers.domain;

import java.util.List;

public class Super {
    private String nickname;
    private SuperType superType;
    private List<String> powers;

    public Super() {
        this(null, null, null);
    }

    public Super(String nickname, SuperType superType, List<String> powers) {
        this.nickname = nickname;
        this.superType = superType;
        this.powers = powers;
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

    public List<String> getPowers() {
        return powers;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }
}
