package com.petartotev.studentboot.diexamples;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeyImpl implements Prototypey {
    private int num = 0;

    public int doPrototypey() {
        num++;
        return num;
    }
}
