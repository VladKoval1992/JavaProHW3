public class Main {

    public static void main(String[] args) {

        MyClass in = new MyClass();
        System.out.println("in\n" + in);

        SerialaizerService out = new SerialaizerService("C:\\", in.getClass().getName());
        out.serializer(MyClass.class);

        MyClass likeNew = (MyClass) out.deSerializer(MyClass.class);
        System.out.println("Out\n" + likeNew);
    }
}