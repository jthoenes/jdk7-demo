package de.bergischweb.kojug.jdk7.coin;

import java.util.Locale;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public abstract class SwitchWithStrings {

    public void perfom(char userInput) {
        userInput = Character.toUpperCase(userInput);
        switch (userInput) {
            case 'Y':
                performYes();
                break;
            case 'N':
                performNo();
                break;
            case 'C':
                performCancel();
                break;
            case 'A':
                performYesToAll();
                break;
            default:
                throw new IllegalArgumentException();

        }
    }

    public void perfom(String userInput) {
        userInput = userInput.toLowerCase(Locale.US);
        switch (userInput) {
            case "YES":
                performYes();
                break;
            case "NO":
                performNo();
                break;
            case "CANCEL":
                performCancel();
                break;
            case "YES TO ALL":
                performYesToAll();
                break;
            case "NO TO ALL":
                performNoToAll();
                break;
            default:
                throw new IllegalArgumentException();

        }
    }

    public void perfomIf(String userInput) {
        userInput = userInput.toLowerCase(Locale.US);
        if (userInput.equals("YES"))
            performYes();
        else if (userInput.equals("NO"))
            performNo();
        else if (userInput.equals("CANCEL"))
            performCancel();
        else if (userInput.equals("YES TO ALL"))
            performYesToAll();
        else if (userInput.equals("NO TO ALL"))
            performNoToAll();
        else
            throw new IllegalArgumentException();

    }

protected abstract void performYes();

    protected abstract void performNo();

    protected abstract void performCancel();

    protected abstract void performYesToAll();

    protected abstract void performNoToAll();
}
