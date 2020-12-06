package co.com.moviedb.moviedb.framework.util;

public class TextManager {
    public static String nvl(String value, String defaultValue){
        if(value.isEmpty()) 
        	value = defaultValue;
        return value;
    }

    public static Object nvl(Object value, String defaultValue){
        if ( null !=  defaultValue && value instanceof String)
            return nvl((String) value, (String) defaultValue);
        if ( null == value ) 
        	value = defaultValue;
        return value;
    }
    
    public static Boolean isNull(Object value) {
    	if (null == value)
    		return true;
    	else if (value instanceof String && value.equals(""))
    		return true;
    	return false;
    }
}