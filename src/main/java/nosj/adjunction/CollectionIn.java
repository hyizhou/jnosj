package nosj.adjunction;


import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 将list这些解析成json
 * @author Yizhou
 * @date 2019/9/26
 */
public interface CollectionIn {

    /**
     * 解析list成json
     * 如：[1,2] -> {key:[1,2]}
     * @param key
     * @param list
     */
    void putList(String key, List list);

    void putSet(String key, Set set);

    void put(String key, Collection collection);

}
