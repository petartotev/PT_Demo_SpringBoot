package com.petartotev.studentboot.diexamples;

import org.springframework.stereotype.Service;

@Service
public class SingletonyImpl implements Singletony {
    private int num = 0;

    public int doSingletony() {
        num++;
        return num;
    }
}
