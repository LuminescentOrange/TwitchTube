package com.jupiter.service;

/**
 * @author qiyuanc
 * @Description
 * @date 2022/2/26 12:32
 */
public class TwitchException extends RuntimeException {
    public TwitchException(String errorMessage) {
        super(errorMessage);
    }
}