public class Main {
    public static void main(String[] args) {

        MyArray array = new MyArray();
        array.add("sdad");
        array.add(5);
        array.add(3);
        array.add(2);
        array.add(1);
        array.add(7);

        System.out.println(array);

        array.remove(3);
        System.out.println(array);


    }
}
