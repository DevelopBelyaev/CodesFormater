/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.conextManagers;

import com.mycompany.codesformatter.formatter.FormatterContext;
import java.util.List;

/**
 *
 * @author nick
 */
public class LevelUpHandler implements StateHandler{

    @Override
    public StringBuilder handle(List<StateHandler> commands, FormatterContext context, String lexema) {
        int offset = ((Integer)context
                .getStateForKeyOrDefault("offset", new Integer(0)));
        int level = ((Integer)context
                .getStateForKeyOrDefault("level", new Integer(0)));
        context.setStateForKey(level + 1, "level");
        return Tabulator.tabing(offset).append(lexema);
    }
    
}
