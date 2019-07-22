package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        BlackBoxInt blackBoxInt = null;
        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue" );
        innerValue.setAccessible(true);
        String input = "";

        try{
            Constructor ctor =  BlackBoxInt.class.getDeclaredConstructor();
            ctor.setAccessible(true);

             blackBoxInt = (BlackBoxInt) ctor.newInstance();}

        catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        while (!"END".equals(input = scanner.nextLine())){

            String command = input.substring(0, input.indexOf("_"));
            int value = Integer.parseInt( input.substring(input.indexOf("_")+1));

          Method method =  Arrays.stream(methods)
                    .filter(m -> m.getName().equals(command))
                    .findFirst()
                    .orElse(null);

            method.setAccessible(true);

            try {
                method.invoke(blackBoxInt, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            try {
                System.out.println(innerValue.getInt(blackBoxInt));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
