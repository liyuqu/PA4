public enum HeroType {
    Warrior(1, "Warrior"),
    Sorcerer(2, "Sorcerer"),
    Paladin(3, "Paladin");
    private int typeNum;
    private String typeName;

    HeroType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
