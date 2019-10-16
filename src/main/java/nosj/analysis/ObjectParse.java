package nosj.analysis;

/**
 * 解析对象
 *
 * @author Yizhou
 * @date 2019/9/26
 */
public interface ObjectParse {
    /**
     * 传入一个javaBean对象，并转换成json格式
     * 主要是将属性转换成json格式
     * @param bean 需是一个javaBean，拥有get/set方法
     */
    void parse(Object bean);

    /**
     * 传入一个对象，并转换成json格式
     * 将所有属性都转换成json，不管私有的共有的
     * @param object
     */
    void parseUnlimit(Object object);
}
