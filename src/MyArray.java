public class MyArray<T> {

    private static final int DEFAULT_CAPACITY = 10;


    Object[] myArray;


    int index = 0;

    public MyArray() {
        myArray = new Object[DEFAULT_CAPACITY];
    }

    public MyArray(int initial_capacity) {
        if (initial_capacity <= 0) {
            throw new NegativeArraySizeException("Size must be grater than 0");
        }
        this.myArray = new MyArray[initial_capacity];
    }

    @Override
    public String toString() {
        StringBuilder myStringArray = new StringBuilder("[");
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] != null) {
                myStringArray.append(myArray[i]);                                    //Another variant for clear null - Arrays.toString(Arrays.stream(myArray).filter(Objects::nonNull).toArray());
                myStringArray.append(",");
            } else break;
        }
        if (myStringArray.charAt(myStringArray.length() - 1) != '[') {
            myStringArray.deleteCharAt(myStringArray.length() - 1);
        }
        myStringArray.append("]");
        return String.valueOf(myStringArray);
    }


    public void add(T t) {
        if (index <= myArray.length) {
            myArray[index] = t;
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


    public void remove(int index) {
        for (int i = 0; myArray[i] != null; i++) {
            if (i >= index) {
                myArray[i] = myArray[i + 1];
            }

        }

    }

    public Object get(int index) {
        if (myArray[index] != null) {
            return myArray[index];
        }
        throw new IndexOutOfBoundsException("Index " + index + " out of bounds");

    }


    public boolean set(int index, T t) {
        if (myArray[index] != null) {
            myArray[index] = t;
            return true;
        }
        throw new IndexOutOfBoundsException("Index " + index + " out of bounds");

    }


    public void clear() {
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = null;
        }
    }

    public boolean contains(Object object) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == object) {
                return true;
            }
        }
        return false;
    }


    public int indexOf(Object object) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].equals(object) && myArray[i] != null)
                return i;
            else
                return -1;
        }
        return -1;
    }


    public int size() {
        int size = 0;
        for (int i = 0; myArray[i] != null; i++) {
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }


}
