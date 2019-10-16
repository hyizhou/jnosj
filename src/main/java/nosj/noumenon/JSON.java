package nosj.noumenon;


/**
 * @author Yizhou
 * @date 2019/9/26
 */
public class JSON {

    protected StringBuilder jsonStr = new StringBuilder("{");

    /**
     * 获取生成的json字符串
     * 在获取之前，需要先放入信息，否则返回空的json
     * @return
     */
    public String getJSON(){
        return toString();
    }

    @Override
    public String toString() {
        return jsonStr.toString()+"}";
    }
}
