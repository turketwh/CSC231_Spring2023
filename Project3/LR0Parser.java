import java.util.*;

public class LR0Parser {

    // rules is a hashtable holding the grammar rules
    // The key is the rule id (R1, R2, ...)
    // and the value is a two part representation of the rule
    // The first part is the non-terminal on the left-hand-side of the rule
    // The second part is the terminals and nonterminals on the right-hand
    // side of the rule
    // If rule R1 was Z --> S#, then the data in the hashtable would be
    // something like: (key: R1, value [Z, S#])
    // This won't matter for the work you need to do, but may be helpful
    // if you read over the code
    protected HashMap<String, ArrayList<String>> rules;

    // table is a hashtable holding the parse table
    // blank entries are not explicitly represented
    // non-blank entries are represented as follows:
    // the key is the state, symbol pair
    // the value is the action to perform (SX, RX, GX, Accept)
    // If the entry for state 1, symbol + was S3, then the data
    // in the hashtable would be something like:
    // (key: 1$+, value: S3)
    // This won't matter for the work you need to do, but may be helpful
    // if you read over the code

    protected HashMap<String, String> table;

    // stack is a Stack data structure that holds the
    // state numbers and input symbols which are
    // inserted onto the stack as the result of shift (SX),
    // reduce (RX), and goto (GX) rules
    protected Stack<String> stack;

    // derivation is a Stack data structure that holds
    // each RX rule when encountered, representing
    // a known derivation step
    protected Stack<String> derivation;

    // This String is the current state (1, 2, 3, ...)
    // that the parser is in
    protected String currentState;

    // This string is the current symbol at the front of
    // the word provided as input
    protected String currentSymbol;

    public LR0Parser() {
        // In the constructor, everything is initialized to be empty
        rules = new HashMap<String, ArrayList<String>>();
        table = new HashMap<String, String>();
        stack = new Stack<String>();
        derivation = new Stack<String>();
        currentState = "";
        currentSymbol = "";
    }
    public void addRule(String labelInput, String lhsInput, String rhsInput) {
        // adds a rule to the rules hashtable
        ArrayList<String> ruleList = new ArrayList<String>();
        ruleList.add(lhsInput);
        ruleList.add(rhsInput);
        rules.put(labelInput, ruleList);
    }

    public String getRuleLHS(String labelInput) {
        // when a rule is requested by id (R1),
        // corresponding non-terminal on the left hand
        // side of the rule is returned
        // if the rule was N --> ab, then N is returned
        if (rules.containsKey(labelInput)) {
            return rules.get(labelInput).get(0);
        }
        else {
            return "NO_SUCH_RULE";
        }
    }

    public String getRuleRHS(String labelInput) {
        // when a rule is requested by id (R1),
        // corresponding non-terminal and terminals on the right hand
        // side of the rule is returned
        // if the rule was N --> ab, then ab is returned
        if (rules.containsKey(labelInput)) {
            return rules.get(labelInput).get(1);
        }
        else {
            return "NO_SUCH_RULE";
        }
    }

    public void addAction(String stateInput, String symbolInput, String actionInput) {
        // adds an action to the parse table
        String key = stateInput + "$" + symbolInput;
        table.put(key, actionInput);
    }

    public String getAction(String stateInput, String symbolInput) {
        // returns the action in the parse table based on the current state
        // and current symbol at the front of the input word
        String key = stateInput + "$" + symbolInput;
        if (table.containsKey(key)) {
            return table.get(key);
        }
        else {
            return "Blank";
        }
    }

    public String getDerivation() {
        // returns the set of grammar rules (RX, RX, RX, ...)
        // that the parsing algorithm discovered to be
        // the appropriate derivation.  This information is available
        // from the stack variable named derivation
        String derivationString = "";
        // TODO



        // END TODO
        return derivationString;
    }

    public String getError() {
        // returns an error message indicating what the erroneous
        // unexpected symbol was when the error occurred
        String errorMessage = "Unexpected ";
        // TODO



        // END TODO
        return errorMessage;
    }

    public String parse(String word) {

        // initialization of stack and remaining input word
        String remainingInput = word;
        stack.push("1");
        int lengthOfWord = remainingInput.length();

        // while there are more symbols in the input word
        while (remainingInput.length() > 0) {
            // current state is at the top of the stack
            currentState = stack.peek();

            // current symbol is at the front of the remaining input
            currentSymbol = "" + remainingInput.charAt(0);

            // look up appropriate action
            String action = getAction(currentState, currentSymbol);

            // if action is Blank, get the appropriate error message and
            // leave the function
            if (action.equals("Blank")) {
                return getError();
            }
            // if action is Accept, get the derivation and leave the function
            else if (action.equals("Accept")) {
                remainingInput = remainingInput.substring(1);
                derivation.push("R1");
                return getDerivation();
            }
            // if the action is SX for Shift, then the stack and current input need to change
            // see Project Description document
            else if (action.charAt(0) == 'S') {
                // TODO



                // END TODO
            }
            // if the action is RX for reduce, then
            // - get the associated rule (left-hand-side LHS and right-hand-side RHS)
            // - pop off the stack 2x * the length of the RHS of the rule
            // - push the LHS of the rule onto the stack
            // - push the rule id onto the derivation stack
            // - look up the goto action and push the associated
            //         new state onto the stack
            else if (action.charAt(0) == 'R') {
                String ruleLHS = getRuleLHS(action);
                String ruleRHS = getRuleRHS(action);
                int countToPop = ruleRHS.length() * 2;
                for (int i = 0; i < countToPop; i++) {
                    stack.pop();
                }
                String previousState = stack.peek();
                stack.push(ruleLHS);
                derivation.push(action);

                // this is where the GX (goto) rule is handled
                String gotoAction = getAction(previousState, ruleLHS);
                String newState = gotoAction.substring(1);
                stack.push(newState);
                currentState = newState;
            }
        }
        return "";
    }
}
