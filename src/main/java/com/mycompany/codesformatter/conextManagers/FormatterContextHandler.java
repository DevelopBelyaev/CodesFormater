/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.conextManagers;
import com.mycompany.codesformatter.formatter.FormatterContext;
import com.mycompany.codesformatter.formatter.FormatterState;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nick
 */
public class FormatterContextHandler implements ContextHandler{
    HashMap<String, List<StateHandler>> handlersMap;
    List<StateHandler> stateHandlers;
    List<FormatRule> rulez;
    List<StateHandler> defaultHandlers;
    public FormatterContextHandler(HashMap<String, List<StateHandler>> handlersMap, 
            List<FormatRule> rulez, List<StateHandler> defaultHandlers) {
        this.handlersMap = handlersMap;
        this.rulez = rulez;
        this.defaultHandlers = defaultHandlers;
    }
    void addHandlersForLexema(String lexema) {
        List<StateHandler> handlers = handlersMap.getOrDefault(lexema, defaultHandlers);
        for(StateHandler handler: handlers) {
            stateHandlers.add(handler);
        }        
    }
    void applyRulez() {        
        for(FormatRule rule:rulez) {
            rule.applyFor(stateHandlers);
        }
    }
    @Override
    public String handle(String lexema, FormatterContext context) {
        stateHandlers = new LinkedList<>();
        addHandlersForLexema(lexema);
        applyRulez();
        StringBuilder result = new StringBuilder();
        for(StateHandler handler: stateHandlers) {
            result.append(handler.handle(stateHandlers, context, lexema));
        }       
        return result.toString();
    }
    
}
