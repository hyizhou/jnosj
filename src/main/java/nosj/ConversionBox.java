package nosj;

import xyz.earthsky.nosj.analysis.JsonOfBean;
import xyz.earthsky.nosj.analysis.JsonOfMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * 本类用于将各种数据转换成字符串
 * @author Yizhou
 * @date 2019/10/4
 */
public class ConversionBox {

    /**
     * 给定对象，判断与自定类型的对应关系
     * @param obj 需判断类型的对象
     * @return
     */
    static public Type analysisType(Object obj){
        if (obj == null){
            return Type.NULL;
        }
        if (obj instanceof Byte ||
            obj instanceof Short ||
            obj instanceof Integer ||
            obj instanceof Long ||
            obj instanceof Float ||
            obj instanceof Double ||
//            obj instanceof Character ||
            obj instanceof Boolean
        ) {
            return Type.BASIC;
        }
        if (obj instanceof Character || obj instanceof String){
            return Type.STR;
        }
        if (obj instanceof Collection){
            return Type.COLLECTION;
        }
        if (obj instanceof Map){
            return Type.MAP;
        }
        return Type.OBJECT;

    }


    /**
     * 判断传入对象是否为：基本数据类型，字符串，Collection
     *   这些对象特点是可以通过toSring直接获得字符串
     * @param obj 检测的对象
     * @return
     */
    static private boolean isOrdinary(Object obj){
        Type type = analysisType(obj);
        return type == Type.BASIC || type == Type.STR || type == Type.COLLECTION;
    }

    static private boolean isOrdinary(Type type){
        return type == Type.BASIC || type == Type.STR || type == Type.COLLECTION;
    }

    /**
     * 将collection转换成string
     *      本方法先判断是否有值，再将元素取出，通过valueToString方法将元素转换成字符串，
     *      再将此字符串拼接到StringBuilder中
     * @param collection 传入值，要存在元素
     * @return 转换成的字符串
     */
    static public String collectionToString(Collection collection){
        if (collection == null){
            return null;
        }
        if (!collection.isEmpty()){
            Iterator iterator = collection.iterator();
            StringBuilder sb = new StringBuilder("[");
            for (;;) {
                Object element = iterator.next();
                String elementStr = valueToString(element);
                sb.append(elementStr);
                if (!iterator.hasNext()){
                    return sb.append("]").toString();

                }
                sb.append(",");
            }

        }else {
            return "[]";
        }

    }

    /**
     * 将某变量解析成字符串返回
     * @param value 传入变量，包括Javabean，Collection，极本数据类型等
     * @return 变量解析后的字符串
     */
    static public String valueToString(Object value){
        Type type = analysisType(value);
        if (type == Type.NULL){
            //到底是返回null还是“null”
            return "null";
        }
        //基本数据类型
        if (isOrdinary(value)){
            if (type == Type.STR){
                return "\""+value.toString()+"\"";
            }
            if (type == Type.COLLECTION){
                return collectionToString((Collection) value);
            }
            return value.toString();
        }
        //map类型
        if (value instanceof Map){
            //创建一个新的mapJson对象
            JsonOfMap mapJson =  new JsonOfMap();
            mapJson.mapAutoParse((Map) value);
            return mapJson.getJSON();
        }
        //javaBean类型
        JsonOfBean jb = new JsonOfBean();
        jb.parse(value);
        return jb.getJSON();
    }
}
