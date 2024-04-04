import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {
    private String model,gosNumber;
    private int year, probeg;
    private boolean used;
    private int motorVolume;

    private static final long serialVersionUID = 213213213123213L;

    public Car(String model, String gosNumber, int year, int probeg, boolean used, int motorVolume) {
        this.model = model;
        this.gosNumber = gosNumber;
        this.year = year;
        this.probeg = probeg;
        this.used = used;
        this.motorVolume = motorVolume;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }


    public String getGosNumber() {
        return gosNumber;
    }


    public int getYear() {
        return year;
    }

    public int getProbeg() {
        return probeg;
    }

    public boolean isUsed() {
        return used;
    }

    public static boolean gosNumAvable(String gosNumber){
        boolean result = gosNumber.matches("\\S\\d\\d\\d\\S\\S");
        if (!result){
            System.out.println("Гос номер не соответсвует формату");
        }
        return result;
    }

    public int getMotorVolume() {
        return motorVolume;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getModel());
        out.writeObject(this.getYear());
        out.writeObject(this.getGosNumber());
        out.writeObject(this.getProbeg());
        out.writeObject(this.isUsed());
        out.writeObject(this.getMotorVolume());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.model = (String) in.readObject();
        this.year = (int) in.readObject();
        this.gosNumber = (String) in.readObject();
        this.probeg = (int) in.readObject();
        this.used = (boolean) in.readObject();
        this.motorVolume = (int) in.readObject();
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", gosNumber='" + gosNumber + '\'' +
                ", year=" + year +
                ", probeg=" + probeg +
                ", used=" + used +
                ", motorVolume=" + motorVolume +
                '}';
    }
}
