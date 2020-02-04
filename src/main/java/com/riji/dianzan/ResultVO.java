package com.riji.dianzan;

/**
 * @author 杨鹏发
 * @date 2020/2/3 0003
 */
public class ResultVO {
    private Integer code;
    private String message;
    private boolean flage;

    public ResultVO() {
    }

    public ResultVO(Integer code, String message, boolean flage) {
        this.code = code;
        this.message = message;
        this.flage = flage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlage() {
        return flage;
    }

    public void setFlage(boolean flage) {
        this.flage = flage;
    }
}
