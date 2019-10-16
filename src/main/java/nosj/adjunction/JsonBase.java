package nosj.adjunction;

import xyz.earthsky.nosj.noumenon.JSON;

/**
 * 抽象类，生成存储json字符串的属性，和获取json字符串的方法
 * @author Yizhou
 * @date 2019/9/18
 */
public class JsonBase extends JSON implements BaseIn {


    protected void addOfType(String type, String key, String value){
        //判断json是否为空
        if (jsonStr.length()>1){
            jsonStr.append(",");
        }
        jsonStr.append("\"").append(key).append("\"").append(":").append(value);
    }


    /**
     * 精简参数，增加json一对键值
     * @param key key
     * @param value value
     */
    protected void addOfType(String key, String value){
        addOfType("null", key, value);
    }


    @Override
    public void put(String key, String value) {
        value = "\""+value+"\"";
        addOfType("string",key,value);
    }

    @Override
    public void put(String key, int value) {
        addOfType("int",key,String.valueOf(value));
    }

    @Override
    public void put(String key, boolean value) {
        addOfType("boolean",key,String.valueOf(value));
    }
}
