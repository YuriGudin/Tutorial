package design_patterns.Command;

/*
 * Напишите свой класс Stringbuilder с поддержкой операции undo.
 * Для этого делегируйте все методы стандартному Stringbuilder, а в
 * Вашем классе храните список всех операций для выполнения undo().
 * Это будет реализацией шаблона "Команда": ​ru.wikipedia.org/wiki/Команда_(шаблон_проектирования)
 *
 */

import java.util.Stack;

abstract class Command {
    abstract void execute();
}

class MyStringBuilder {
    private StringBuilder stringBuilder;
    private Stack<Command> stack;

    public MyStringBuilder(){
        stringBuilder = new StringBuilder();
        stack = new Stack<Command>();
    }

    public MyStringBuilder append(Object obj) {
        final int start = stringBuilder.length();
        stringBuilder.append(obj.toString());
        final int end = stringBuilder.length();


        stack.push(new Command() {
            @Override
            void execute() {
                stringBuilder.delete(start, end);
            }
        });

        return this;
    }

    public MyStringBuilder delete(final int start, final int end) {

        stack.push(new Command() {
            String string = stringBuilder.substring(start, end);

            @Override
            void execute() {
                stringBuilder.insert(start, string);
            }
        });
        stringBuilder.delete(start, end);
        return this;
    }

    public MyStringBuilder insert(final int offset, final String str) {

        stringBuilder.insert(offset, str);
        stack.push(new Command() {
            @Override
            void execute() {
                stringBuilder.delete(offset, offset+str.length());
            }
        });

        return this;
    }

    public MyStringBuilder reverse() {

        stack.push(new Command() {
            @Override
            void execute() {
                stringBuilder.reverse();
            }
        });

        stringBuilder.reverse();
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    public MyStringBuilder undo() {
        stack.pop().execute();
        return this;
    }
}

public class Task {

    public static void main(String[] args) {

        MyStringBuilder myStringBuilder = new MyStringBuilder();
        myStringBuilder.append("123456");
        System.out.println(myStringBuilder.toString());

        myStringBuilder.reverse();
        System.out.println(myStringBuilder.toString());

        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());

        myStringBuilder.append("ТЕСТ");
        System.out.println(myStringBuilder.toString());

        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());

        System.out.println("--------");
        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());

        myStringBuilder.append("123456");
        System.out.println(myStringBuilder.toString());

        myStringBuilder.insert(0, "ТЕСТ");
        System.out.println(myStringBuilder.toString());
        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());

        myStringBuilder.delete(0, 3);
        System.out.println(myStringBuilder.toString());
        myStringBuilder.undo();
        System.out.println(myStringBuilder.toString());


    }
}