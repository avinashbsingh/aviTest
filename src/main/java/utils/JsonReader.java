package utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonReader {
    public static HashMap<String, String> readJsonFile(String jsonFilePath, String Env, String Client) {
        HashMap<String, String> config_map = new HashMap<>();
        Object obj;

        try {
            obj = new JSONParser().parse(new FileReader(jsonFilePath));
            JSONObject jsonObject = (JSONObject) obj;
            Map client = (Map) jsonObject.get(Client);
            Map env = (Map) client.get(Env);
            //config_map = env.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
            Iterator<Map.Entry> ite1 = env.entrySet().iterator();
            while (ite1.hasNext()) {
                Map.Entry pair = ite1.next();
                config_map.put(pair.getKey().toString(), pair.getValue().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return config_map;
    }

    public static JsonNode readJsonFile(String filePath) throws IOException {
        JSONParser parser = new JSONParser();
        JsonNode rootNode = null;
        BufferedReader br = null;
        Object obj;
        ObjectMapper mapper = new ObjectMapper();

        try {
            FileReader reader = new FileReader(new File(filePath));
            br = new BufferedReader(reader);
            obj = parser.parse(br);
            rootNode = mapper.readTree(new StringReader(obj.toString()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
        }
        return rootNode;
    }

    public static JsonNode setJsonNodeValue(JsonNode node, String attribute, String value) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = null;
        JsonNode rootarray = mapper.readTree(String.valueOf(node));
        ((ObjectNode) rootarray).put(attribute, value);
        return rootarray;
    }

    public static JsonNode setJsonNodeValues(JsonNode node, String attribute, String values) {
        String[] collectionAttribute = attribute.split("\\,");
        String[] collectionValue = values.split("\\,");
        int counter = 0;
        for (String attribute1 : collectionAttribute) {
            String[] attributes = attribute1.split("\\.");
            JsonNode tempJson = node;
            String lastAttribute = "";
            int lengthOfAttribute = attributes.length;
            for (int i = 0; i < lengthOfAttribute; i++) {
                String nodeType = tempJson.get(attributes[i]).getNodeType().toString();
                if (nodeType.equalsIgnoreCase("ARRAY")) {
                    ArrayNode arrayNode = (ArrayNode) tempJson.get(attributes[i].trim());
                    tempJson = arrayNode.get(0);
                }
            }
            lastAttribute = attributes[lengthOfAttribute - 1];
            ObjectNode objNode = (ObjectNode) tempJson;
            objNode.put(lastAttribute, collectionValue[counter]);
            counter++;
        }
        return node;
    }


}
