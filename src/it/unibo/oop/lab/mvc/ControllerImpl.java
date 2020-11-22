package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller {
    private final List<String> history;
    private String nextStr;

    public ControllerImpl() {
        history = new LinkedList<>();
    }

    @Override
    public final void setNextString(final String string) {
        if (string != null) {
            this.nextStr = string;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public final String getNextString() {
        return nextStr;
    }

    @Override
    public final List<String> getHistory() {
        return new ArrayList<String>(history);
    }

    @Override
    public final void printCurrentString() {
        if (nextStr != null) {
            history.add(nextStr);
            System.out.println(nextStr);
        } else {
            throw new IllegalStateException();
        }
    }

}
