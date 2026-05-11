package com.example.airportcheckinandbaggagemanagement;

import java.util.Stack;

public class BaggageStack {

    Stack<Passenger> stack = new Stack<>();

    // PUSH
    public void addBaggage(Passenger p) {
        stack.push(p);
    }

    // POP
    public Passenger removeBaggage() {
        if (!stack.isEmpty())
            return stack.pop();
        return null;
    }

    // SHOW STACK
    public String showBaggage() {
        if (stack.isEmpty()) return "📭 No baggage loaded.";

        StringBuilder result = new StringBuilder("🧳 Baggage Stack (Top → Bottom):\n");
        for (int i = stack.size() - 1; i >= 0; i--) {
            result.append(stack.get(i)).append("\n");
        }
        return result.toString();
    }
}
