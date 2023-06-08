package ma.sir.pmp.zynerator.process;

import org.apache.commons.collections4.map.HashedMap;

import java.util.Map;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;

public class AbstractProcessInput  extends AuditBaseDto{
    private Map<String, Object> attributes;

    public int putAttribute(String key, Object value) {
        Map<String, Object> map = getAttributes();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals(key)) {
                map.replace(key, value);
                return -1;
            }
        }
        map.put(key, value);
        return 1;
    }


    public <T> T getAttribute(String key) {
        Map<String, Object> map = getAttributes();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals(key)) {
                return (T) map.get(key);
            }
        }
        return null;
    }

    public Map<String, Object> getAttributes() {
        if (attributes == null) {
            attributes = new HashedMap<>();
        }
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
