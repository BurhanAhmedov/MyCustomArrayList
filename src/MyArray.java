import java.util.Arrays;

public class MyArray {

    private static final int DEFAULT_CAPACITY = 10;

    Object[] myArray = new Object[DEFAULT_CAPACITY];


    int index = 0;

    public MyArray() {

    }

    public MyArray(int initial_capacity) {
        if (initial_capacity <= 0) {
            throw new NegativeArraySizeException("Size must be grater than 0");
        }
        this.myArray = new Object[initial_capacity];
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "myArray=" + Arrays.toString(myArray) +
                '}';
    }


    public void add(Object object) {
        if (index <= myArray.length) {
            myArray[index] = object;
            index++;

            int nullCount = 0;
            for (Object obj : myArray) {
                if (obj == null) {
                    nullCount++;
                }
            }
            if (myArray.length * 0.25 >= nullCount) {      //Increase capacity of array when 75% length filled
                Object[] newArr = new Object[(myArray.length * 3) / 2 + 1];
                for (int i = 0; i < myArray.length; i++) {
                    newArr[i] = myArray[i];
                }
                myArray = newArr;


            }
        } else {
            throw new IndexOutOfBoundsException();
        }


    }

}
