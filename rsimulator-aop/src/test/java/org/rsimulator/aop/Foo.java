package org.rsimulator.aop;

import org.springframework.stereotype.Service;

@Service
public interface Foo {

    public String sayHello(String msg);
}