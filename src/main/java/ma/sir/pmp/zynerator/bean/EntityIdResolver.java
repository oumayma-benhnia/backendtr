package ma.sir.pmp.zynerator.bean;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

/**
 * @author fta on 20.12.15.
 */

public class EntityIdResolver implements ObjectIdResolver {

    @Override
    public void bindItem(final ObjectIdGenerator.IdKey id, final Object pojo) {
        //Not used
    }

    @Override
    public Object resolveId(final ObjectIdGenerator.IdKey id) {

        BusinessObject o = null;
        try {
            if (id.key != null) {
                Long idEntity = Long.valueOf(id.key.toString());
                Object obj = id.scope.newInstance();
                if (obj instanceof BusinessObject) {
                    o = (BusinessObject) obj;
                    o.setId(idEntity);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return o;
    }

    @Override
    public ObjectIdResolver newForDeserialization(final Object context) {

        return this;
    }

    @Override
    public boolean canUseFor(final ObjectIdResolver resolverType) {

        return false;
    }

}