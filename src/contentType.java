public enum contentType {
    market("$"),random(" "),hero("H"),inaccessible("X");

    private String icon;

    contentType(String icon){
        this.icon=icon;
    }
    public String geticon(){
        return icon;
    }


}
