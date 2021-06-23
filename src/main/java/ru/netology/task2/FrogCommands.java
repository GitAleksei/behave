package ru.netology.task2;

public class FrogCommands {
    public static FrogCommand jumpRightCommand(final Frog frog, final int steps) {
        return new FrogCommand() {
            @Override
            public boolean _do() {
                return frog.jump(steps);
            }

            @Override
            public boolean _undo() {
                return frog.jump(-steps);
            }
        };
    }

    public static FrogCommand jumpLeftCommand(final Frog frog, final int steps) {
        return new FrogCommand() {
            @Override
            public boolean _do() {
                return frog.jump(-steps);
            }

            @Override
            public boolean _undo() {
                return frog.jump(steps);
            }
        };
    }
}
