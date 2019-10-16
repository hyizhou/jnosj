package nosj.adjunction;

import nosj.ConversionBox;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 这个类用来将collection解析成json
 *
 * @author Yizhou
 * @date 2019/10/3
 */
public class CollectionPut extends JsonBase implements CollectionIn {
    /**
     * 将解析成字符串的collection存入json字符
     *
     * @param key
     * @param value
     */
    private void putCollection(String key, String value) {
        addOfType("collection", key, value);
    }

    /**
     * 解析collection
     *
     * @param key key值
     * @param collection 键值对应变量
     */
    @Override
    public void put(String key, Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            String value = ConversionBox.collectionToString(collection);
            putCollection(key, value);
        }
    }

    @Override
    public void putList(String key, List list) {
        put(key, list);
    }

    @Override
    public void putSet(String key, Set set) {
        put(key, set);
    }


//    /**
//     * 判断collection里面是否什么都没有
//     *
//     * @param key        json中的key
//     * @param collection 要转换城json的内容
//     * @return true表示collection中空空如也，false表示其中有值
//     */
//    private boolean isNothing(String key, Collection collection) {
//        if (null == collection) {
//            putCollection(key, "null");
//            return true;
//        }
//        if (collection.size() == 0) {
//            putCollection(key, "[]");
//            return true;
//        }
//        return false;
//    }

}
