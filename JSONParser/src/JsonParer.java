import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

class JsonParser {

    static class User {

        List<String> user;

        @Override
        public String toString() {
            return "{\n" +
                    "“name”: “…”,\n" +
                    "“surname”: “…”,\n" +
                    "“phones”: [“044-256-78-90”, “066-123-45-67”, …],\n" +
                    "“sites”: [“http://site1.com”, “http://site2.com”, …],\n" +
                    "“address”: {\n" +
                    "“country”: “…”,\n" +
                    "“city”: “…”,\n" +
                    "“street”: “…”\n" +
                    "}\n" +
                    "}";
        }
    }

    public static void main(String[] args) {

        //Создаем эклемпляр пользователя
        User user = new User();
        user.user = new ArrayList<>();
        user.user.add("Java");
        user.user.add("C++");
        user.user.add("PHP");
        user.user.add("LaTeX");

        //Создаем экземпляр Gson
        Gson gson = new Gson();

        //Сериализуем пользователя в JSON и выведем в консоль
        String JSON  = gson.toJson(user);
        System.out.println (JSON);


    }
}
