package com.patika.cohort3.library.utilities;

import com.patika.cohort3.library.result.Result;
import com.patika.cohort3.library.result.ResultData;
import com.patika.cohort3.library.utilities.Message;
import org.springframework.data.domain.Page;

public class ResultHelper {

    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Message.CREATED,"201",data);
    }

    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(false,Message.VALIDATE_ERROR,"400",data);
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(true, Message.OK,"200",data);
    }

    public static Result ok() {
        return new Result(true, Message.OK,"200");
    }

    public static Result notFoundError(String msg) {
        return new Result(false, msg,"404");
    }

    public static Result alreadyExist(String msg) {
        return new Result(false, msg,"500");
    }

//    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData) {
//        CursorResponse<T> cursor = new CursorResponse<>();
//        cursor.setItems(pageData.getContent());
//        cursor.setPageNumber(pageData.getNumber());
//        cursor.setPageSize(pageData.getSize());
//        cursor.setTotalElements(pageData.getTotalElements());
//        return ResultHelper.success(cursor);
//    }
}
