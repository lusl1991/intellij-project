package com.softel.model.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ParseJson {

    public String ReadFile(String Path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    public static void main(String[] args){
        String path = "E:\\package.json";
        String JsonContext = new ParseJson().ReadFile(path);
        JSONArray jsonArray = JSONArray.fromObject(JsonContext);
        List<FaultCode> list = JSONArray.toList(jsonArray,FaultCode.class);
        int size = jsonArray.size();
        System.out.println("Size: " + size);
        for(int  i = 0; i < size; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println("[" + i + "]code=" + jsonObject.get("code"));
            System.out.println("[" + i + "]msg=" + jsonObject.get("msg"));
            System.out.println("[" + i + "]details=" + jsonObject.get("details"));
        }

        for(int i = 0; i < list.size(); i++){
            FaultCode faultCode = list.get(i);
            System.out.println("code="+faultCode.getCode()+",msg="+faultCode.getMsg()+",details="+faultCode.getDetails());
        }
    }
}
