import java.io.*;

public class LoaderRunnable implements Runnable{
    private String path;

    public LoaderRunnable(String path) {
        this.path = path;
    }
    @Override
    public void run() {
        if (new File(this.path).exists()) {
            FileInputStream fis;
            try {
                fis = new FileInputStream(this.path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Car car = new Car();
                car.readExternal(ois);
                ois.close();
                System.out.println(car.toString());
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден: "+e.getMessage());
            } catch (IOException e) {
                System.out.println("Ошибка при загрузке файла: "+e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Ошибка, класс не найден: " + e.getMessage());
            }
        }
    }
}
