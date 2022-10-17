package com.vchicken.opencommon.model.result;

import java.lang.annotation.*;

/**
 * @author vchicken
 * @date 2021-05-31 4:19 下午
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoResponse2Result {
}
