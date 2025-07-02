package memento;

import java.util.ArrayList;
import java.util.List;

public class ExpenseHistory {

    private List<ExpenseMemento> history;

    public ExpenseHistory() {
        this.history = new ArrayList<>();
    }

    public void addMemento(ExpenseMemento memento) {
        this.history.add(memento);
    }

    public ExpenseMemento getMemento() {
        if (!history.isEmpty()) {
            return history.remove(history.size() - 1);
        }
        return null;
    }

    public ExpenseMemento getMemento(int index) {
        if (index >= 0 && index < history.size()) {
            return this.history.get(index);
        }
        return null;
    }
}
