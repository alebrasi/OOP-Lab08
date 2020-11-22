package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller {
    private final List<String> history;

    //Redundant but in such way I don't have to get the last item of the Linked list each time
    private String currentStr;
    private String nextStr;

    public ControllerImpl() {
        history = new LinkedList<>();
    }

    @Override
    public final void setNextString(final String string) throws NullPointerException {
        if (string != null) {
            nextStr = string;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public final String getNextString() {
        currentStr = nextStr;
        return nextStr;
    }

    @Override
    public final List<String> getHistory() {
        return new ArrayList<String>(history);
    }

    @Override
    public final void printCurrentString() throws IllegalStateException {
        if (currentStr != null) {
            history.add(currentStr);
            System.out.println(currentStr);
        } else {
            throw new IllegalStateException();
        }
    }

}
