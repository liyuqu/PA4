public enum MonsterType {
    Dragons(1,"Dragons"),Exoskeletons(2,"Exoskeletons"),Spirits(3,"Spirits");

    private int typeNum;
    private String typeName;

    MonsterType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }

    public int getTypeNum() {
        return typeNum;
    }
}
