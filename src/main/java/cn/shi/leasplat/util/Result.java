package cn.shi.leasplat.util;

import cn.shi.leasplat.util.ResultError;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:        Result
 *
 * @Description   返回信息实体
 *
 * @author        ʯǿ
 *
 * @Time          2016-12-23 11:02:29
 *
 * @version       1.0
 *
 */
public class Result {

    /**
     * 返回
     */
    private ResultError error;

    /**
     * 返回内容
     */
    private Object data;

    public Result()
    {
        this.error = new ResultError();
        this.error.setCode(1);
    }

    public Result(BindingResult bindingResult)
    {
        if (null == bindingResult) return;
        this.error = new ResultError(bindingResult);
        this.error.setCode(1);
        if (bindingResult.hasErrors())
        {
            this.error.setCode(2);
            this.error.setReason("表单验证错误");
        }
    }

    public ResultError getError() {
        if(error==null){
            error = new ResultError();
        }
        return error;
    }

    public boolean hasErrors()
    {
        return (error != null && error.getCode() != 1);
    }

    public void setError(ResultError error) {
        this.error = error;
    }

    public Result setError(Exception ex)
    {
        ex.printStackTrace();
        if (ex instanceof RuntimeException)
        {
            this.setError(0, ex.getMessage());
        }
        else
        {
            this.setError(0, "ϵͳ����");
        }
        return this;
    }

    public Result setError(int code, String reason)
    {
        this.error = new ResultError();
        this.error.setCode(code);
        this.error.setReason(reason);

        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static final Map<String, Object> values(Object... args)
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        if (args.length % 2 != 0) throw new RuntimeException("参数个数必须为偶数个");
        for (int i = 0; i < args.length; i+=2)
        {
            values.put(String.valueOf(args[i]), args[i + 1]);
        }
        return values;
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println(values("config", "1122", "age", 23, "sex", "male"));
    }
}
