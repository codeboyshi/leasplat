package cn.shi.leasplat.util;



import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回错误实体
 */
public class ResultError {
    /**
     * 返回代码 0 失败 1 成功
     */
    private Integer code;
    /**
     * 返回错误消息
     */
    private String reason;

    private List<FieldError> fieldErrors;

    public ResultError()
    {
        // ...
    }

    public ResultError(BindingResult result)
    {
        // ...
        this.fieldErrors = result.getFieldErrors();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
