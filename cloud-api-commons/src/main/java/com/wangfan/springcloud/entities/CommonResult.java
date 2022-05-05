package com.wangfan.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResult
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

  private Integer code;
  private String message;
  private T data;

  public CommonResult(Integer code, String message) {
    this(code, message, null);
  }
}
