package enumgeneralization;

/**
 * Created by olexandra on 04.10.15.
 */
public enum Names{
    PASHA("boy", "Pashen'ka"),
    MASHA("girl", "Mashen'ka"),
    SASHA("both", "Sashen'ka");

    String gender, pettingName;

    Names(String gender, String pettingName) {
        this.gender = gender;
        this.pettingName = pettingName;
    }

    public static Names getNameByPettingName(String pettingName) {
        return EnumGeneralization.getNameByPettingName(pettingName, Names.values());
    }

    public String getPettingName() {
        return pettingName;
    }


    public void setPettingName(String pettingName) {
        this.pettingName = pettingName;
    }


}
