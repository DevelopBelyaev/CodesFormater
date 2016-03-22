/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.formatter;

/**
 *
 * @author nick
 */
public interface FormatterContext {
    public Object getStateForKey(Object key);
    public void setStateForKey(Object state, Object key);
    public boolean containsKey(Object key);
    public Object getStateForKeyOrDefault(Object key, Object def);
    
}
