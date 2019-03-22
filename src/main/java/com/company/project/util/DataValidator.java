package com.company.project.util;

import org.json.JSONObject;

/***
 * Check validity of data
 * @author Chao Li
 */
public class DataValidator {

    /***
     * Check if an object is String
     * @param obj object to be checked
     * @return true: is string, false: not string
     */
    public static boolean isString(Object obj) {
        if (obj.getClass().getName().equals("java.lang.String")){
            return true;
        }
        return false;
    }

    /***
     * Check if a jsonObj contains the key and if the related value is not empty
     * @param jsonObj jsonObject which contains the key
     * @param key key to be checked
     * @return true: there is a non-empty value for the key, false: any other situations
     */
    public static boolean isValidKey(JSONObject jsonObj, String key){
        if (jsonObj.has(key) && isString(jsonObj.get(key))
                && !jsonObj.getString(key).isEmpty()){
            return true;
        }
        return false;
    }

    /***
     * Check if the response is success
     * @param jsonObj jsonObject in the response
     * @return true: status code is 200, false: any other status codes
     */
    public static boolean isSuccessResponse(JSONObject jsonObj){
        if (DataValidator.isValidKey(jsonObj, "Status")
                && jsonObj.getString("Status").equals("200")){
            return true;
        }
        return false;
    }
}
