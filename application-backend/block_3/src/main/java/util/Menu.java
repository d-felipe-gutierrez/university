package util;

import java.util.Scanner;

public class Menu {
    private String question;
    private MenuItem[] items;
    private String keyExit, exitMsg;
    private Scanner sc = new Scanner(System.in);

    public Menu(String question, MenuItem[] items, String keyExit, String exitMsg) {
        this.question = question;
        this.items = items;
        this.keyExit = keyExit;
        this.exitMsg = exitMsg;
    }

    public Menu(MenuItem[] items, String keyExit, String exitMsg) {
        this("Select an option", items, keyExit, exitMsg);
    }

    public Menu(String question, MenuItem[] items) {
        this(question, items, "q", "Quit / Go back");
    }

    public Menu(MenuItem[] items) {
        this("Select an option", items, "q", "Quit / Go back");
    }

    public void printQuestion() {
        System.out.println(question);
    }

    public void printOptions() {
        for (MenuItem item : items) {
            System.out.println(item.getKey() + ". " + item.getText());
        }
        System.out.println(keyExit + ". " + exitMsg);
    }

    public String getSelection() {
        System.out.print("Option: ");
        return sc.nextLine();
    }

    public MenuItem getItem(String key) {
        for (MenuItem item : items) {
            if (key.equals(item.getKey())) {
                return item;
            }
        }
        return null;
    }

    public void run() {
        while (true) {
            System.out.println();
            printQuestion();
            printOptions();
            String op = getSelection();

            if (op.equals(keyExit)) {
                break;
            }

            MenuItem item = getItem(op);

            if (item != null) {
                item.execute();
            } else {
                System.out.println("Invalid option...");
            }
        }
    }
}