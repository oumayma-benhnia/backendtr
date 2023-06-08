package ma.sir.pmp.zynerator.util;

import ma.sir.pmp.zynerator.bean.BusinessObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BusinessObjectUtil {

    public static Long[] getIdTab(List<? extends BusinessObject> list) {
        Long[] res = null;
        if (list != null && !list.isEmpty()) {
            Long[] ids = new Long[list.size()];
            int i = 0;
            for (BusinessObject obj : list) {
                ids[i] = obj.getId();
                i++;
            }
            res = ids;
        } else
            res = new Long[0];
        return res;
    }

    public static List<Long> getIdsList(Set<? extends BusinessObject> list) {
        List<Long> result = new ArrayList<Long>();
        if (list != null && !list.isEmpty()) {
            for (BusinessObject obj : list) {
                result.add(obj.getId());
            }
        }
        return result;
    }


    public static List<String> getIdsToList(List<? extends BusinessObject> list) {
        List<String> l = null;
        if (list != null && !list.isEmpty()) {
            l = new ArrayList<String>();
            for (BusinessObject obj : list) {
                l.add(obj.getId().toString());
            }
        }
        return l;
    }


    public static Long[] getIdTab(Set<? extends BusinessObject> set) {
        Long[] res = null;
        if (set != null && !set.isEmpty()) {
            Long[] ids = new Long[set.size()];
            int i = 0;
            for (BusinessObject obj : set) {
                ids[i] = obj.getId();
                i++;
            }
            res = ids;
        } else
            res = new Long[0];
        return res;
    }


}
