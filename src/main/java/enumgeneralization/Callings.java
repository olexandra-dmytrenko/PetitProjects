package enumgeneralization;

/**
 * Created by olexandra on 05.10.15.
 */
public enum Callings implements EnumGeneralization {
    SOLNTSE("solnishko"), DOZHD("dozhdik");

    String pettingName;

    Callings(String pettingName) {
        this.pettingName = pettingName;
    }

    @Override
    public String getPettingName() {
        return pettingName;
    }

    public static Callings getNameByPettingName(String pettingName) {
        return (Callings) EnumGeneralization.getNameByPettingName(pettingName, Callings.values());
    }
}
