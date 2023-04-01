public enum PotionAffectType {
    Health(1, "Health"),
    Strength(2, "Strength"),
    Mana(3, "Mana"),
    Agility(4, "Agility"),
    Health_Mana_Strength_Agility(5, "Health/Mana/Strength/Agility"),
    All(9, "All");
    private int typeNum;
    private String typeName;

    public static String getSymbolByIndex(int index){
        for(PotionAffectType increaseType : PotionAffectType.values()){
            if(index == increaseType.getTypeNum()){
                return increaseType.getTypeName();
            }
        }
        return "";
    }

    public static int getTypeNumBySymbol(String symbol){
        for(PotionAffectType type : PotionAffectType.values()){
            if(type.getTypeName().equals(symbol)){
                return type.getTypeNum();
            }
        }
        return 99;
    }


    PotionAffectType(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }

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
}
