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
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
