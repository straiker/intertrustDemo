package rait.demo.utils;

import rait.demo.data.TestData;

import java.text.MessageFormat;

public class Utils {
    public static String getAPIUrl(){
        return MessageFormat.format(TestData.API_URL, TestData.CITY_NAME, TestData.API_KEY);
    }
}
