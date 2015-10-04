package enumgeneralization;

import java.util.Arrays;

/**
 * Created by olexandra on 05.10.15.
 */
public interface EnumGeneralization {
    public String getPettingName();

    public static EnumGeneralization getNameByPettingName(final String pettingName, EnumGeneralization[] names) {
        return Arrays.stream(names).filter(name -> name.getPettingName().equals(pettingName)).findAny().orElse(null);
    }
}
