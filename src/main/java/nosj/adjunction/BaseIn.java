package nosj.adjunction;

/**
 * json简单类型的加入所规定的接口
 * 主要是：数字，字符串，逻辑值，null
 *
 * @author Yizhou
 * @date 2019/9/18
 */
public interface BaseIn {

    /**
     * 放入一个字符串字段
     * @param key 键值
     * @param value 属性值
     */
    void put(String key, String value);

    void put(String key, int value);

    void put(String key, boolean value);

//    /**
//     * 放入一个Object对象，此对象是基本数据类型的对象
//     * @param key 键值
//     * @param baseValue 基本数据类型变量值
//     * @param cla 传出数据类型
//     */
//    void put(String key, Object baseValue, Class cla);
}
