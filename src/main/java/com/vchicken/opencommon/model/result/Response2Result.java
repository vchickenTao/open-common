package com.vchicken.opencommon.model.result;

import java.lang.annotation.*;

/**
 * 将响应结果封装为{@link Result}结果
 *
 * @author vchicken
 * @date 2020-10-25 2:14 下午
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Response2Result {
}
