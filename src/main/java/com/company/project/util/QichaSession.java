package com.company.project.util;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;

public class QichaSession {
    @Value("${qichacha.address}")
    private static String qichaUrl;

    private static ClassPathResource qichaRSdata = new ClassPathResource("static/data/qichaResponseStatus.json");

    public static HashMap<String, String> responseStatusMap = loadStatusCode();

    private static HashMap<String, String> loadStatusCode(){
        HashMap<String, String> map = new HashMap<>();
        try{
            byte[] bytes = FileCopyUtils.copyToByteArray(qichaRSdata.getInputStream());
            String jsonStr = new String(bytes, StandardCharsets.UTF_8);
            JSONObject jsonObj = new JSONObject(jsonStr);
            Iterator iter = jsonObj.keys();
            while (iter.hasNext()){
                String key = (String) iter.next();
                String value = jsonObj.getString(key);
                map.put(key, value);
            }
        } catch (IOException e){
            System.out.println(e);
        }
        return map;
    }

    public static String search(String credit_code){
        StringBuffer resultBuffer = new StringBuffer();
        try {
            URL url = new URL(qichaUrl+credit_code);
            //打开http连接
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            //获得输入
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //将bufferReader的值给放到buffer里
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                resultBuffer.append(str);
            }
            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            //断开连接
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回字符串
        String result = resultBuffer.toString();
        return result;
    }



}
