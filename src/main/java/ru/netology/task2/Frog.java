package ru.netology.task2;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() { position = 5; }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        if (position + steps >= MIN_POSITION && position + steps <= MAX_POSITION) {
            position += steps;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Frog:\n");
        for (int i = MIN_POSITION; i < MAX_POSITION + 1; i++) {
            stringBuilder.append("|");
            if (i == position) {
                stringBuilder.append("*");
            } else {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }
}
