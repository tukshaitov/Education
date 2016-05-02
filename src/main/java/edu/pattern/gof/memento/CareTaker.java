package edu.pattern.gof.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Care Taker */
public class CareTaker {
    private List<SpreadSheet.Memento> mementoList = new ArrayList<SpreadSheet.Memento>();
    private SpreadSheet spreadSheet;

    public CareTaker(SpreadSheet spreadSheet) {
        this.spreadSheet = spreadSheet;
    }

    public void save() {
        mementoList.add(spreadSheet.getIncrementalMemento());
    }

    public void undo() {
        int lastIndex = mementoList.size() - 1;

        if (lastIndex == -1)
            spreadSheet.restoreFromMemento(null);
        else {
            if (spreadSheet.restoreFromMemento(mementoList.get(lastIndex)) == RestoreStatus.MEMENTO)
                mementoList.remove(lastIndex);
        }
    }
}
