package com.conpany.project.util;

import com.company.project.util.DataValidator;
import com.conpany.project.Tester;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataValidatorTester extends Tester{
    @Test
    public void isStringTest(){
        String str = "Test";
        Integer number = 123;
        assertEquals(true, DataValidator.isString(str));
        assertEquals(false, DataValidator.isString(number));
    }

    @Test
    public void isValidKeyTest() {
        String jsonStr = "{\n" +
                "  \"Status\": \"200\",\n" +
                "  \"Message\": \"\",\n" +
                "  \"OrderNumber\": null,\n" +
                "}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        String key1 = "Result";
        String key2 = "Status";
        String key3 = "Message";
        String key4 = "OrderNumer";
        assertEquals(false, DataValidator.isValidKey(jsonObj, key1));
        assertEquals(true, DataValidator.isValidKey(jsonObj, key2));
        assertEquals(false, DataValidator.isValidKey(jsonObj, key3));
        assertEquals(false, DataValidator.isValidKey(jsonObj, key4));
    }

    @Test
    public void isSuccessResponseTest(){
        String jsonStr1 = "{\n" +
                "  \"Status\": \"200\",\n" +
                "}";
        JSONObject jsonObj1 = new JSONObject(jsonStr1);
        assertEquals(true, DataValidator.isSuccessResponse(jsonObj1));
        String jsonStr2 = "{\n" +
                "  \"Status\": \"300\",\n" +
                "}";
        JSONObject jsonObj2 = new JSONObject(jsonStr2);
        assertEquals(false, DataValidator.isSuccessResponse(jsonObj2));
        String jsonStr3 = "{\n" +
                "  \"Stat\": \"300\",\n" +
                "}";
        JSONObject jsonObj3 = new JSONObject(jsonStr3);
        assertEquals(false, DataValidator.isSuccessResponse(jsonObj3));
    }
}
