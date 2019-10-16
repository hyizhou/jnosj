package nosj.analysis;

import xyz.earthsky.nosj.ConversionBox;
import xyz.earthsky.nosj.adjunction.CollectionPut;

import java.lang.reflect.Field;

/**
 * @author Yizhou
 * @date 2019/10/11
 */
public class JsonOfBean extends CollectionPut implements ObjectParse {
    @Override
    public void parse(Object bean) {
        Field[] fields = bean.getClass().getFields();
        for (Field field : fields) {
            String key = field.getName();
            Object valueObj;
            try {
                valueObj = field.get(bean);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("解析属性错误，请检查javaBean");
            }
            String value = ConversionBox.valueToString(valueObj);
            addOfType(key, value);
        }
    }

    @Override
    public void parseUnlimit(Object object) {
        //先懒得写了
        return;
    }
}
