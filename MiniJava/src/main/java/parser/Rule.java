package parser;

import Log.LogUtils;
import scanner.token.Token;
import scanner.type.Type;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammad hosein on 6/25/2015.
 */
public class Rule {
    public Rule(String stringRule) {
        int index = stringRule.indexOf("#");
        if (index != -1) {
            try {
            semanticAction = Integer.parseInt(stringRule.substring(index + 1));
            }catch (NumberFormatException ex){
                semanticAction = 0;
            }
            stringRule = stringRule.substring(0, index);
        } else {
            semanticAction = 0;
        }
        String[] splited = stringRule.split("->");
//        try {
            LHS = NonTerminal.valueOf(splited[0]);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        RHS = new ArrayList<GrammarSymbol>();
        if (splited.length > 1) {
            String[] RHSs = splited[1].split(" ");
            for (String s : RHSs){
                try {
                    RHS.add(new GrammarSymbol(NonTerminal.valueOf(s)));
                } catch (Exception e) {
//                    try{
                        RHS.add(new GrammarSymbol(new Token(Token.getTyepFormString(s), s)));
//                    }catch (IllegalArgumentException d){
//                        d.printStackTrace();
//                        Log.print(s);
//                    }
                }
            }
        }
    }
    public NonTerminal LHS;
    public List<GrammarSymbol> RHS;
    public int semanticAction;
}

class GrammarSymbol{
    private boolean isTerminal;
    private NonTerminal nonTerminal;
    private Token terminal;

    public boolean isTerminal() {
        return isTerminal;
    }

    public NonTerminal getNonTerminal() {
        return nonTerminal;
    }

    public Token getTerminal() {
        return terminal;
    }

    public void setNonTerminal(NonTerminal nonTerminal) {
        this.nonTerminal = nonTerminal;
    }

    public void setTerminal(Token terminal) {
        this.terminal = terminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }

    public GrammarSymbol(NonTerminal nonTerminal)
    {
        this.nonTerminal = nonTerminal;
        isTerminal = false;
    }
    public GrammarSymbol(Token terminal)
    {
        this.terminal = terminal;
        isTerminal = true;
    }
}
