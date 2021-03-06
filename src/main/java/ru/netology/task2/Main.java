package ru.netology.task2;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Frog frog = new Frog();
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        int action;
        boolean exit = true;
        FrogCommand cmd;
        int steps;

        while (exit) {
            System.out.println(frog);
            System.out.println(curCommand + "  " + commands.size());
            action = requestAction();
            switch (action) {
                case 1:
                    if (curCommand != commands.size() - 1) {
                        Iterator<FrogCommand> iterator = commands.iterator();
                        for (int i = 0; i <= curCommand; i++) {
                            iterator.next();
                        }
                        while (iterator.hasNext()) {
                            iterator.next();
                            iterator.remove();
                        }
                    }
                    steps = requestSteps();
                    if (steps == -1) {
                        break;
                    }
                    cmd = FrogCommands.jumpRightCommand(frog, steps);
                    curCommand++;
                    commands.add(cmd);
                    cmd._do();
                    break;

                case 2:
                    if (curCommand != commands.size() - 1) {
                        Iterator<FrogCommand> iterator = commands.iterator();
                        for (int i = 0; i <= curCommand; i++) {
                            iterator.next();
                        }
                        while (iterator.hasNext()) {
                            iterator.next();
                            iterator.remove();
                        }
                    }
                    steps = requestSteps();
                    if (steps == -1) {
                        break;
                    }
                    cmd = FrogCommands.jumpLeftCommand(frog, steps);
                    curCommand++;
                    commands.add(cmd);
                    cmd._do();
                    break;

                case 3:
                    if (curCommand < 0) {
                        System.out.println("???????????? ????????????????!");
                    } else {
                        commands.get(curCommand)._undo();
                        curCommand--;
                    }
                    break;

                case 4:
                    if (curCommand == commands.size() - 1) {
                        System.out.println("???????????? ??????????????????!");
                    } else {
                        curCommand++;
                        commands.get(curCommand)._do();
                    }
                    break;

                case 5:
                    commands.get(curCommand)._do();
                    commands.add(commands.get(curCommand));
                    curCommand++;
                    break;

                case 6:
                    exit = false;
                    break;
            }
        }
    }

    public static int requestSteps() {
        int steps;
        try {
            System.out.println("?????????????? ???????????????? ????????????: ");
            steps = Integer.parseInt(scanner.nextLine());
        }
        catch (Exception ex) {
            System.out.println("?????????? ?????????????? ?????????? ??????????!");
            return -1;
        }
        return steps;
    }

    public static int requestAction() {
        int action;
        try {
            System.out.println("1. ???????????????? ????????????;");
            System.out.println("2. ???????????????? ??????????;");
            System.out.println("3. ???????????????? ?????????????????? ??????????????;");
            System.out.println("4. ?????????????????? ???????????????????? ??????????????;");
            System.out.println("5. ?????????????????? ?????????????????? ??????????????;");
            System.out.println("6. ??????????.");
            System.out.println("???????????????? ????????????????: ");
            action = Integer.parseInt(scanner.nextLine());
            if (action < 1 || action > 6) {
                throw new IllegalArgumentException();
            }
        }
        catch (Exception ex) {
            System.out.println("?????????? ?????????????? 1, 2, 3, 4, 5, 6!");
            return -1;
        }
        return action;
    }
}