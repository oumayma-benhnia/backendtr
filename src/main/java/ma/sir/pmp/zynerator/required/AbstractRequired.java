package ma.sir.pmp.zynerator.required;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractRequired<DTO, DTO_TAB> {
    private Class<DTO> dtoClass;
    private Class<DTO_TAB> dtoTableClass;


    public List<DTO> findAll() {
        String url = getMsUrl() + getLocalUrl();
        DTO[] dtos = (DTO[]) getRestTemplate().getForEntity(url, dtoTableClass).getBody();
        return Arrays.asList(dtos);
    }

    public <CRITERIA> List<DTO> findByCriteria(@RequestBody CRITERIA criteria) {
        String url = getMsUrl() + getLocalUrl() + "find-by-criteria";
        DTO[] dtos = (DTO[]) getRestTemplate().postForEntity(url, criteria, dtoTableClass).getBody();
        return Arrays.asList(dtos);
    }

    public <T> T getOne(String url, Class<T> clazz) {
        return getRestTemplate().getForEntity(url, clazz).getBody();
    }

    public <T> void getMultiple(String url, Class<T[]> clazzTable) {
        //restTemplate.getForEntity(url, clazzTable).getBody();
    }

    public AbstractRequired(Class<DTO> dtoClass, Class<DTO_TAB> dtoTableClass) {
        this.dtoClass = dtoClass;
        this.dtoTableClass = dtoTableClass;
    }

    public abstract String getMsUrl();

    public abstract String getLocalUrl();

    public abstract RestTemplate getRestTemplate();
}
