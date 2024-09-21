package org.hua.tiktok.exception;

import org.hua.tiktok.util.R;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringJoiner;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public R ex(Exception e) {
        e.printStackTrace();
        String msg = ObjectUtils.isEmpty(e.getMessage()) ? e.toString() : e.getMessage();
        return R.error().message(msg);
    }

    @ExceptionHandler(Exception.class)
    public R bex(BaseException e) {
        return R.error().message(e.getMessage());
    }

    //数据校验异常处理
    public R exception(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringJoiner joiner = new StringJoiner(",");

        bindingResult.getFieldErrors().stream().forEach((fieldError -> {
            joiner.add(fieldError.getDefaultMessage());
        }));
        return R.error().message(joiner.toString());
    }


}
