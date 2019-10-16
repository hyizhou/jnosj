package nosj.analysis;

import xyz.earthsky.nosj.ConversionBox;
import xyz.earthsky.nosj.Type;
import xyz.earthsky.nosj.adjunction.CollectionPut;

import java.util.Map;

/**
 * @author Yizhou
 * @date 2019/10/4
 */
public class JsonOfMap extends CollectionPut implements MapParse {
    @Override
    public void mapParse(Map map, Type type) {
        map.forEach((key,value)->{
            //判断key是否为String
            if (!(key instanceof String)) {
                throw new RuntimeException("key应为String类型");
            }
            String keyStr = (String) key;
            String valueStr = null;


            //解析value为String
            switch (type){
                case BASIC:

                case COLLECTION:

                default:throw new RuntimeException("Map中类型不正确");

            }

        });
    }

    /**
     * 将map解析成json，且自动分析其中数据类型
     * @param map map
     */
    public void mapAutoParse(Map map){
        if (null != map){
            for (Object entry : map.entrySet()) {
                String valueStr = ConversionBox.valueToString(((Map.Entry) entry).getValue());
                String keyStr = (String) ((Map.Entry) entry).getKey();
                putValue(null,keyStr,valueStr);
            }
        }
        //map为空则json也应为空：{}，但此时什么也不用操作
        return;
    }

    private void putValue(String type, String key, String value){
        addOfType(type,key,value);
    }
}
