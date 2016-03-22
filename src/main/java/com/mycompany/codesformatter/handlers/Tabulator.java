/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.handlers;

/**
 *
 * @author nick
 */
class Tabulator {
    
     static StringBuilder tabing(int level) {
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < level; i++) {
            tab.append("  ");
        }
        return tab;
    }
    
}
