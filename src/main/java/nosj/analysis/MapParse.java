package nosj.analysis;


import nosj.Type;

import java.util.Map;

/**
 * 将map解析成json
 * @author Yizhou
 * @date 2019/10/4
 */
public interface MapParse {
    void mapParse(Map map, Type type);
}
