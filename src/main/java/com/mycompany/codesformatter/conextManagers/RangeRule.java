/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.conextManagers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.springframework.util.comparator.ComparableComparator;

/**
 *
 * @author nick
 */
public class RangeRule implements FormatRule{
    HashMap<StateHandler, Integer> priorityMap;
    public RangeRule(HashMap<StateHandler, Integer> priorityMap) {
        this.priorityMap =  priorityMap;
    }
    @Override
    public void applyFor(Object target) {
        List<StateHandler> context = (List)target;
        context.sort(new Comparator<StateHandler> () {

            @Override
            public int compare(StateHandler o1, StateHandler o2) {
                return new ComparableComparator<Integer>()
                        .compare(priorityMap.get(o1),  priorityMap.get(o2));
            }
        });
    }
    
}
