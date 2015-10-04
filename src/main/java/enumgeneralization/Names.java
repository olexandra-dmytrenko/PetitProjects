package enumgeneralization;

/**
 * Created by olexandra on 04.10.15.
 */
public enum Names implements EnumGeneralization {
    PASHA("boy", "Pashen'ka"),
    MASHA("girl", "Mashen'ka"),
    SASHA("both", "Sashen'ka");

    String gender, pettingName;

    Names(String gender, String pettingName) {
        this.gender = gender;
        this.pettingName = pettingName;
    }

    public static Names getNameByPettingName(String pettingName) {
        return (Names) EnumGeneralization.getNameByPettingName(pettingName, Names.values());
    }

    @Override
    public String getPettingName() {
        return pettingName;
    }
}
