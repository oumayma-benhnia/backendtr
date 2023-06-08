package ma.sir.pmp.zynerator.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        if (isEmpty(list)) {
            List<T> myList = new ArrayList<>();
                return myList;
        } else {
            return list;
        }
    }
    public static List removed(List coll1, List coll2) {
        List intersection = new ArrayList();
        if (coll1 != null)
            for (Object object : coll1) {
                if (coll2 != null && !coll2.contains(object))
                    intersection.add(object);
            }

        return intersection;
    }

    public static List added(List coll1, List coll2) {
        List intersection = new ArrayList();
        if (coll2 != null)
            for (Object object : coll2) {
                if (coll1 != null && !coll1.contains(object))
                    intersection.add(object);
            }

        return intersection;
    }

}
