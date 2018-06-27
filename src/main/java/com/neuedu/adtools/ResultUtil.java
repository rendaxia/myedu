package com.neuedu.adtools;

import java.util.List;
public class ResultUtil {
    public static Result success(String []object) {
        Result result = new Result();
        result.setErrno(0);
        result.setData(object);
        return result;
    }
    public static Result success() {
        return success(null);
    }

}

