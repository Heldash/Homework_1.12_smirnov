import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Смирнов Игорь Евгеньевич, РИБО-01-22, Вариант 1");
        Scanner scan = new Scanner(System.in);
        String model;
        String gosNumber = "";
        int year = 0;
        int probeg = 0;
        boolean used = false;
        int motorVolume = -1;
        System.out.print("Введите модель машины: ");
        model = scan.nextLine();
        while (year == 0) {
            System.out.print("Введите год выпуска машины: ");
            try {
                year = scan.nextInt();
                if (year <1900){
                    System.out.println("Год выпуска не может быть меньше 1900 года");
                    year = 0;
                }
            }catch (InputMismatchException ex){
                System.out.println("Вы ввели не число введите еще раз");
                scan.nextLine();
                year = 0;
            }
        }
        scan.nextLine();
        while (gosNumber.isEmpty()){
            System.out.print("Введите гос номер машины:");
            gosNumber = scan.nextLine();
            boolean isMatch = Car.gosNumAvable(gosNumber);
            if (!isMatch){
                gosNumber = "";
            }
        }
        String yesNo = "";
        while (yesNo.isEmpty()){
            System.out.print("Машина новая? Введите да или нет: ");
            yesNo = scan.next();
            if (yesNo.equalsIgnoreCase("да")){
                used =false;
            } else if (yesNo.equalsIgnoreCase("нет")) {
                used = true;
            } else{
                System.out.println("Я вас не понимаю введите да или нет: ");
                yesNo = "";
            }
        }
        if (!used){
            probeg = 0;
        }else {
            while (probeg == 0){
                System.out.print("Введите пробег машины: ");
                try {
                    probeg = scan.nextInt();
                    if (probeg<=0){
                        System.out.println("Пробег не может быть отрицательный или равен нулю если машина не новая");
                        probeg = 0;
                    }
                }catch (InputMismatchException ex){
                    System.out.println("Вы ввели не число, введите еще раз");
                    scan.nextLine();
                    probeg = 0;
                }
            }
        }
        while (motorVolume<=0){
            System.out.print("Введите обьем двигателя: ");
            try {
                motorVolume = scan.nextInt();
                if (motorVolume<=0){
                    System.out.println("Объем мотора не может быть меньше или равен нулю");
                }
            } catch (InputMismatchException ex){
                System.out.println("Вы ввели не число, введите значение правильно");
                scan.nextLine();
                motorVolume = -1;
            }
        }
        Car car = new Car(model,gosNumber,year,probeg,used,motorVolume);
        Thread saver = new Thread(new SaverRunnable(car));
        saver.start();
//        try {
//            saver.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Thread loader = new Thread(new LoaderRunnable("C:\\car.ser"));
//        loader.start();
    }
}