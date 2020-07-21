package AtSchool;

import com.google.gson.*;
import java.lang.reflect.Type;

public class AClassAdapter implements JsonSerializer<Animal>, JsonDeserializer<Animal> {
  @Override
  public JsonElement serialize(Animal src, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject result = new JsonObject();
    result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
    result.add("properties", context.serialize(src, src.getClass()));
    return result;
  }


  @Override
  public Animal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
          throws JsonParseException {
    JsonObject jsonObject = json.getAsJsonObject();
    String type = jsonObject.get("type").getAsString();
    JsonElement element = jsonObject.get("properties");

    try {
      String thepackage = "AtSchool";
      return context.deserialize(element, Class.forName(thepackage + type));
    } catch (ClassNotFoundException cnfe) {
      throw new JsonParseException("Unknown element type: " + type, cnfe);
    }
  }
}
