package ma.sir.pmp.zynerator.util;

import ma.sir.pmp.zynerator.audit.AuditEntity;
import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.bean.BusinessObject;
import ma.sir.pmp.zynerator.bean.EnumBean;
import ma.sir.pmp.zynerator.dto.BaseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


/**
 * Some utils functionnality
 */
public abstract class Utils {

    public static final String MESSASGE_RESOURCES = "messages.properties";
    public static final String APPLICATION_RESOURCES = "application.properties";
    public static final String DEFAULT_APP_NAME = "RADIOTHERAPIE";
    public static final String LOG = "Log";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";

    private Utils() {
    }

    public static boolean isNoItemInArray(String[] array) {
        if (array == null)
            return true;
        return ((array.length == 1) && !StringUtils.hasText(array[0]));
    }

    public static URL getResourceFromcClassPath(String name) throws IOException {
        Resource resource = new ClassPathResource(name);
        return resource.getURL();
    }

    public static String getProperties(String name, String key) throws IOException {
        Properties properties = null;
        InputStream inputStream = null;
        InputStreamReader reader = null;
        try {
            properties = new Properties();
            inputStream = new FileInputStream(getResourceFromcClassPath(name).getFile());
            reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            properties.load(reader);
        } catch (Exception e) {
            throw e;
        } finally {
            if (inputStream != null)
                inputStream.close();
            if (reader != null)
                reader.close();
        }
        return properties.getProperty(key);
    }


    /**
     * @param externalEnum
     * @return list liste des valeurs de l'enumération
     */
    public static <T extends Enum<T>> List<EnumBean> enumToList(final T[] externalEnum) throws IOException {
        List<EnumBean> list = new ArrayList();
        for (int i = 0; i < externalEnum.length; i++) {
            String key = externalEnum.getClass().getSimpleName().replaceAll(";", "").toLowerCase() + "."
                    + externalEnum[i].toString();
            EnumBean form = new EnumBean(externalEnum[i].ordinal(), getProperties(MESSASGE_RESOURCES, key));
            list.add(form);
        }
        return list;
    }

    public static List<? extends Object> getSourceList(List<? extends Object> source, List<? extends Object> target) {
        if (source != null && target != null) {
            for (Object src : target) {
                BusinessObject o = (BusinessObject) src;
                source.remove(o);
            }
        }
        return source;
    }


    public static <T extends BaseDto> List<AuditEntity> compareObjects(T newVal, T oldVal) throws NoSuchMethodException {
        List<AuditEntity> list = new ArrayList();
        LocalDateTime d = LocalDateTime.now();
        for (Method method : newVal.getClass().getDeclaredMethods()) {
            Annotation tagAnnotation = logAnnotation(method);
            handelTagAnnotaion(newVal, oldVal, list, d, method, tagAnnotation);
        }
        return list;
    }

    private static <T extends BaseDto> void handelTagAnnotaion(T newVal, T oldVal, List<AuditEntity> list, LocalDateTime d, Method method, Annotation tagAnnotation) throws NoSuchMethodException {
        if (tagAnnotation != null) {
            Object value1 = getMethodValue(method, newVal, tagAnnotation);
            Method method2 = constructMethode(newVal, oldVal, method);
            Object value2 = getMethodValue(method2, oldVal, tagAnnotation);
            if (BooleanUtil.isNotEquals(value1, value2)) {
                boolean collection = BooleanUtil.isaBoolean(value1, value2);
                if (collection) {
                    AuditEntityUtil.handlCollection(oldVal, list, d, method, value1, value2);
                } else {
                    AuditEntityUtil.handelNonCollection(oldVal, list, d, method, value1, method2, value2);
                }
            }
        }
    }

    private static <T extends BaseDto> Method constructMethode(T newVal, T oldVal, Method method) throws NoSuchMethodException {
        Method method2 = null;
        if (oldVal != null)
            method2 = oldVal.getClass().getMethod(method.getName(), method.getParameterTypes());
        else if (newVal != null)
            method2 = newVal.getClass().getMethod(method.getName(), method.getParameterTypes());
        return method2;
    }


    public static <T extends BaseDto> boolean compareObjectsDiff(T newVal, T oldVal) throws NoSuchMethodException {
        for (Method method : newVal.getClass().getDeclaredMethods()) {
            Annotation tagAnnotation = logAnnotation(method);
            if (tagAnnotation != null) {
                Object value1 = getMethodValue(method, newVal, tagAnnotation);
                Method method2 = constructMethode(newVal, oldVal, method);
                Object value2 = getMethodValue(method2, oldVal, tagAnnotation);
                boolean changed = BooleanUtil.isNotEquals(value1, value2);
                if (changed)
                    return true;
            }
        }
        return false;
    }

    public static Object getMethodValue(Method method, Object newVal, Annotation annotation) {
        Object object = null;
        if (method != null) {
            try {
                object = method.invoke(newVal);
                if (object instanceof BaseDto) {
                    object = ((BaseDto) object).getId();
                } else if (object instanceof LocalDateTime) {
                    if (object != null) {
                        Log log = (Log) annotation;
                        if (log.format() != null && log.format().equalsIgnoreCase(DD_MM_YYYY))
                            object = DateUtil.dateToString(((LocalDate) object));
                        else if (log.format() != null && log.format().equalsIgnoreCase(DD_MM_YYYY_HH_MM))
                            object = DateUtil.dateTimeToString(((LocalDateTime) object));
                    }
                }
            } catch (Exception e) {
            }
        }

        return object;
    }

    public static Annotation logAnnotation(Method method) {
        for (Annotation annotation : method.getAnnotations()) {
            if (annotation.annotationType().getSimpleName().equalsIgnoreCase(LOG))
                return annotation;
        }
        return null;
    }

    public static int getIndexSet(Set<? extends Object> set, Object value) {
        int result = 0;
        for (Object entry : set) {
            if (entry.equals(value)) return result;
            result++;
        }
        return -1;
    }

   /* public static void copyNonNullProperties(Object source, Object target) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true);
            try {
                Object sourceValue = sourceField.get(source);
                if (sourceValue != null) {
                Field targetField = target.getClass().getDeclaredField(sourceField.getName());
                targetField.setAccessible(true);
                targetField.set(target, sourceValue);
                }
            } catch (Exception e) {
                // Handle the exception
            }
        }
    }*/

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
            for(java.beans.PropertyDescriptor pd : pds) {
                Object srcValue = src.getPropertyValue(pd.getName());
                if (srcValue == null) emptyNames.add(pd.getName());
            }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}