package com.softberries.shizi.i18n;

import java.io.Serializable;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



/**
 * Used for managing i18n in application for each user
 * @author Krzysztof Grajek
 *
 */
@ManagedBean
@SessionScoped
public class LanguageSwitcher implements Serializable {

	private static final long serialVersionUID = 2756934361134603857L;
	private static final Logger LOG = Logger.getLogger(LanguageSwitcher.class.getName());
	
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	/**
	 * Get the currently set Locale object
	 * @return {@code Locale} - currently set object
	 */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Get the currently set language
     * @return {@code String} language representation eg. 'en'
     */
    public String getLanguage() {
        return locale.getLanguage();
    }

    /**
	 * Sets the current {@code Locale} for each user session
	 * 
	 * @param languageCode - ISO-639 language code
	 */
    public void changeLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
	
}
