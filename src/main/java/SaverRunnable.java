import java.io.*;

public class SaverRunnable implements Runnable{
    private Car car;

    public SaverRunnable(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("C:\\car.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            this.car.writeExternal(oos);
            oos.flush();
            oos.close();
            System.out.println("Объект записан в файл по пути: С:\\car.ser");
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("Не удалось создать файл");
            System.out.println(e.getMessage());
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("Ошибка при записи в файл");
            System.out.println(e.getMessage());
        }
    }
}
