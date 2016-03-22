package com.mycompany.codesformatter.formatter;
import java.util.HashMap;

/**
 *
 * @author nick
 */
public class FormatterState implements FormatterContext{
    HashMap<Object, Object> context;   
    public FormatterState() {
        context = new HashMap<>();
    }
    @Override
    public Object getStateForKey(Object key) {
      return context.get(key);
    }
    @Override
    public void setStateForKey(Object state, Object key) {
        context.put((String) key, state);
    }
    @Override
    public boolean containsKey(Object key) {
        return context.containsKey(key);
    }

    @Override
    public Object getStateForKeyOrDefault(Object key, Object def) {
        return context.getOrDefault(key, def);
    }
}
