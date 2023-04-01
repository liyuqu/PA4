public enum SpellType {
    Ice(1, "Ice"),
    Fire(2, "Fire"),
    Lightning(3, "Lightning");
    private int typeNum;
    private String typeName;

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    SpellType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }
}
