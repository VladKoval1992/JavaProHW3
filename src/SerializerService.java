import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class SerialaizerService {
    private String filePath;
    private String fileName;

    public SerialaizerService(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public void serializer(Class<?> clazz) {
        Map<String, Object> objectStatement = new HashMap<>(4);
        Object instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.isAnnotationPresent(Save.class)) {
                    if (field.getType() == Integer.class) {
                        objectStatement.put(field.getName(), field.getInt(instance));
                    } else if (field.getType() == Double.class) {
                        objectStatement.put(field.getName(), field.getDouble(instance));
                    } else if (field.getType() == Character.class) {
                        objectStatement.put(field.getName(), field.getChar(instance));
                    } else if (field.getType() == java.lang.String.class) {
                        objectStatement.put(field.getName(), field.get(instance));
                    }
                }
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }

            try (PrintWriter writer = new PrintWriter(filePath + fileName + ".txt")) {
                for (Map.Entry<String, Object> entry : objectStatement.entrySet()) {
                    writer.println(entry.getKey() + ":" + entry.getValue());
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Object deSerializer(Class<?> clazz) {
        Object instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath + fileName + ".txt"))) {

            String line = "";
            while ((line = reader.readLine()) != null) {

                String[] temp;
                temp = line.split(":");

                Field field = clazz.getField(temp[0]);
                switch (field.getName()) {
                    case "integer":
                        field.set(instance, Integer.parseInt(temp[1]));
                        break;
                    case "fractional":
                        field.set(instance, Double.parseDouble(temp[1]));
                        break;
                    case "symbol":
                        field.set(instance, temp[1].charAt(0));
                        break;
                    case "text":
                        field.set(instance, temp[1]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return instance;
    }
}