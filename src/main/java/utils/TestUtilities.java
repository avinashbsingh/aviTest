package utils;

import java.util.HashMap;

public class TestUtilities {

    public static void setMasterValues(HashMap<String, String> object) {
        for (Keys key : Keys.values()) {
            if (object.get(key.toString()) != null)
                MasterData.setContext(key, object.get(key.toString()));
        }
    }
}
