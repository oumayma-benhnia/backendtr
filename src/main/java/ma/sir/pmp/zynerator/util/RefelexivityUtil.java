package ma.sir.pmp.zynerator.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class RefelexivityUtil {


    public static void copyIncludesProperties(Object src, Object trg, String[] args) {

        if (args != null) {
            BeanWrapper srcWrap = PropertyAccessorFactory.forBeanPropertyAccess(src);
            BeanWrapper trgWrap = PropertyAccessorFactory.forBeanPropertyAccess(trg);
            List<String> props = Arrays.asList(args);
            props.forEach(p -> trgWrap.setPropertyValue(p, srcWrap.getPropertyValue(p)));
        }
    }

    public static void copyExcludesProperties(Object src, Object dest, String[] args) {
        if (args != null)
            BeanUtils.copyProperties(src, dest, args);
    }

    public static <T> T constructObjectUsingDefaultConstr(Class<T> myclass) {
        try {
            return myclass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T, K> T constructObjectUsingOneParam(Class<T> myclass, K param) {
        try {
            return myclass.getDeclaredConstructor(param.getClass()).newInstance(param);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean methodExists(Class clazz, String methodName) {
        boolean result = false;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
