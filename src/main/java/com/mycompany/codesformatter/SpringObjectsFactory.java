/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author nick
 */
public class SpringObjectsFactory implements ObjectsFactory{
    ClassPathXmlApplicationContext ac;
    public SpringObjectsFactory(String[] configFiles) {
        ac = new ClassPathXmlApplicationContext(configFiles);
    }
    @Override
    public Object getObjectFromClass(String className) {
        return ac.getBean(className);
    }
}
