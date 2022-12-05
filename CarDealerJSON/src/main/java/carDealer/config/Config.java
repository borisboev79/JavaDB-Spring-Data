package carDealer.config;

import com.google.gson.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Configuration
public class Config {



    @Bean
    public ModelMapper createModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public Scanner createScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public Gson createGson(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    @Primary
   // @Qualifier("DateG")
    public static Gson createGsonWithBirthDates(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(LocalDateTime.class, new FromDateTimeToJson())
                .registerTypeAdapter(LocalDateTime.class, new FromJsonToDateTime())
                .create();
    }

    private static class FromDateTimeToJson implements JsonSerializer<LocalDateTime> {

        public JsonElement serialize(LocalDateTime date, Type typOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }

    private static class FromJsonToDateTime implements JsonDeserializer<LocalDateTime> {

        @Override
        public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
            return LocalDateTime.parse(json.getAsString());
        }
    }

    /*@Bean
    public static void writeJsonToFile(Object object, Path filepath) throws IOException {

        final Gson gson = createGsonWithBirthDates();

        final FileWriter fileWriter = new FileWriter(filepath.toFile());

        gson.toJson(object, fileWriter);

        fileWriter.flush();
        fileWriter.close();

    }*/


}
