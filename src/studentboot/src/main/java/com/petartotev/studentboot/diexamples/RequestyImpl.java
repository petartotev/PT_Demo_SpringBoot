package com.petartotev.studentboot.diexamples;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
//@Scope("request")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestyImpl implements Requesty {
    private int num = 0;

    public int doRequesty() {
        num ++;
        return num;
    }
}
