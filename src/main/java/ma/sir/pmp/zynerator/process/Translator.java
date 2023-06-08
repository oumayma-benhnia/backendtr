package ma.sir.pmp.zynerator.process;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {
    private  static ResourceBundleMessageSource resourceBundleMessageSource;

    public Translator(@Qualifier("process-messages") ResourceBundleMessageSource resourceBundleMessageSource) {
        this.resourceBundleMessageSource = resourceBundleMessageSource;
    }

    public static String toLocal(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = resourceBundleMessageSource.getMessage(code, null, locale);
        return message;
    }
}
