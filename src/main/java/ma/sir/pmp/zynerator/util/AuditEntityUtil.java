package ma.sir.pmp.zynerator.util;

import ma.sir.pmp.zynerator.audit.AuditEntity;
import ma.sir.pmp.zynerator.dto.BaseDto;
import ma.sir.pmp.zynerator.enumeration.ACTION_TYPE;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditEntityUtil {


    public static <T extends BaseDto> void handelNonCollection(T oldVal, List<AuditEntity> list, LocalDateTime d, Method method, Object value1, Method method2, Object value2) {
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setColonne(formatName(method.getName()));
        auditEntity.setDateTime(d);
        auditEntity.setUserId(UserUtil.getCurrentUserId());
        auditEntity.setUsername(UserUtil.getCurrentUserName());
        auditEntity.setTypeaction(ACTION_TYPE.UPDATE.getDisplayText());
        auditEntity.setObjectId(oldVal.getId());
        auditEntity.setEnume(method2.getReturnType().isEnum());
        if (method2.getReturnType().isEnum()) {
            auditEntity.setNewValueFormat(((Enum) value1).name());
            auditEntity.setOldValueFormat(((Enum) value2).name());
        } else if (Boolean.class.equals(method2.getReturnType())
                || method2.getReturnType().toString().equals("boolean")) {
            auditEntity.setNewValueFormat(BooleanUtil.getOuiOuNon(value1));
            auditEntity.setOldValueFormat(BooleanUtil.getOuiOuNon(value2));
        } else if (method2.getReturnType().equals(LocalDateTime.class)) {
            auditEntity.setNewValueFormat(DateUtil.dateTimeToString((LocalDateTime) value1));
            auditEntity.setOldValueFormat(DateUtil.dateTimeToString((LocalDateTime) value2));
        } else if (method2.getReturnType().getSuperclass().getSimpleName()
                .equalsIgnoreCase(BaseDto.class.getSimpleName())) {
        } else {
            auditEntity.setNewValueFormat(getEmptyIfNull(value1));
            auditEntity.setOldValueFormat(getEmptyIfNull(value2));
        }
        auditEntity.setNewValue(getEmptyIfNull(value1));
        auditEntity.setOldValue(getEmptyIfNull(value2));
        list.add(auditEntity);
    }


    public static <T extends BaseDto> void handlCollection(T oldVal, List<AuditEntity> list, LocalDateTime d, Method method, Object value1, Object value2) {
        List coll1 = new ArrayList();
        List coll2 = new ArrayList();
        if (BooleanUtil.isaBoolean(value1))
            coll1 = (List) value1;
        if (BooleanUtil.isaBoolean(value2))
            coll2 = (List) value2;
        for (Object object : ListUtil.added(coll2, coll1)) {
            AuditEntity auditEntity = new AuditEntity();
            auditEntity.setColonne(formatName(method.getName()));
            auditEntity.setDateTime(d);
            auditEntity.setUserId(UserUtil.getCurrentUserId());
            auditEntity.setUsername(UserUtil.getCurrentUserName());
            if (NumberUtil.isLong(object)) {
                auditEntity.setNewValue(String.valueOf(object));
            } else if (object instanceof BaseDto) {
                auditEntity.setNewValue(((BaseDto) object).getId().toString());
            }
            auditEntity.setObjectId(oldVal.getId());
            auditEntity.setTypeaction(ACTION_TYPE.ADD.getDisplayText());
            list.add(auditEntity);

        }
        for (Object object : ListUtil.removed(coll2, coll1)) {
            AuditEntity auditEntity = new AuditEntity();
            auditEntity.setColonne(formatName(method.getName()));
            auditEntity.setDateTime(d);
            auditEntity.setUserId(UserUtil.getCurrentUserId());
            auditEntity.setUsername(UserUtil.getCurrentUserName());
            if (NumberUtil.isLong(object)) {
                auditEntity.setOldValue(String.valueOf(object));
            } else if (object instanceof BaseDto) {
                auditEntity.setOldValue(((BaseDto) object).getId().toString());
            }
            auditEntity.setObjectId(oldVal.getId());
            auditEntity.setTypeaction(ACTION_TYPE.DELETE.getDisplayText());
            list.add(auditEntity);
        }
    }


    private static String formatName(String name) {
        if (name != null) {
            if (name.toLowerCase().startsWith("is"))
                name = uncapitalize(name.substring(2));
            else if (name.toLowerCase().startsWith("get"))
                name = uncapitalize(name.substring(3));
        }
        return name;
    }


    private static String uncapitalize(String s_) {
        if (s_ != null && !s_.equals(""))
            return s_.substring(0, 1).toLowerCase() + s_.substring(1);
        return "";
    }


    private static String getEmptyIfNull(Object value) {
        return value != null ? String.valueOf(value) : "";
    }

}
