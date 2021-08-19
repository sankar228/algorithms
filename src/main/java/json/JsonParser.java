package json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonParser {
    public static void main(String[] args) {
        JsonParser obj = new JsonParser();
        //String json = "C:\Users\skataba1\IdeaProjects\algorithms\data\\Cell_cell.json";

        try {
            var lf = Files.list(Path.of("C:\\Users\\skataba1\\IdeaProjects\\algorithms\\data\\")).collect(Collectors.toList());
            for (var p : lf) {
                System.out.println("reading :" + p.getFileName());
                obj.parse(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parse(Path json) {
        try {
            String jsondata = Files.readString(json);
            JSONObject jsonObject = new JSONObject(jsondata);

            JSONArray appDatas = jsonObject.getJSONArray("appData");
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < appDatas.length(); i++) {
                JSONObject appData = appDatas.getJSONObject(i);
                Map<String, Object> values = new LinkedHashMap();

                parseAppData(appData, values);

                var jsonStr = JSONObject.wrap(values);
                System.out.println(jsonStr);
                /*for(Map.Entry<String, Object> entry: values.entrySet()){
                    System.out.println(entry.getKey()+":"+entry.getValue());
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void parseAppData(JSONObject appData, Map<String, Object> values){
        LinkedList<String> elemheirarchy = new LinkedList<>();
        appData.keys().forEachRemaining(appElement -> {
            if("feeders".equals(appElement)){
                System.out.println("feeders");
            }
            var elementObj = appData.get(appElement);
            elemheirarchy.add(appElement);

            if (elementObj instanceof JSONArray) {
                if("customFields".equals(appElement)){
                    parseCustomFieldValues((JSONArray)elementObj, elemheirarchy, values);
                }else {
                    parseArrayValues(elemheirarchy, values, (JSONArray) elementObj);
                }
            } else if (elementObj instanceof JSONObject) {
                parseElementsValues(elemheirarchy, values, (JSONObject) elementObj);
            } else {
                values.put(appElement, elementObj);
                elemheirarchy.removeLast();
            }
            if(elemheirarchy.size() > 0) {
                elemheirarchy.removeLast();
            }
        });
    }

    private void parseElementsValues(LinkedList<String> elemheirarchy, Map<String, Object> values, JSONObject jsonObject) {

        var keys = jsonObject.keySet();
        if (keys == null) return;

        for (String key : keys) {
            elemheirarchy.add(key);
            if (jsonObject.get(key) instanceof JSONObject) {
                parseElementsValues(elemheirarchy, values, (JSONObject) jsonObject.get(key));
            } else if(jsonObject.get(key) instanceof JSONArray){
                parseArrayValues(elemheirarchy, values, (JSONArray) jsonObject.get(key));
            } else {
                String heirarchy = elemheirarchy.stream().collect(Collectors.joining("-"));
                values.put(heirarchy, jsonObject.get(key));
            }

            elemheirarchy.removeLast();
        }


    }

    private void parseArrayValues(LinkedList<String> elemheirarchy,  Map<String, Object> values, JSONArray jsonArray) {

        if(jsonArray == null || jsonArray.length() == 0){
            return;
        }

        for(int elemInx =0; elemInx < jsonArray.length(); elemInx++){
            if(jsonArray.length() > 1){
                elemheirarchy.set(elemheirarchy.size() -1, elemheirarchy.getLast() + "_" +elemInx +1);
            }
            var customElement = jsonArray.get(elemInx);
            if(customElement instanceof JSONObject){
                parseElementsValues(elemheirarchy, values, (JSONObject) customElement);
            }else if(customElement instanceof JSONArray){
                parseArrayValues(elemheirarchy, values, (JSONArray) customElement);
            }/*else{
                String customFiledHeirarchy = elemheirarchy.stream().collect(Collectors.joining("-"));
                values.put(customFiledHeirarchy +"_" +(elemInx +1) + "-"+ ((JSONObject)customElement).get("group"),
                        customElement.optString("value"));
            }*/
        }
    }

    private void parseCustomFieldValues(JSONArray elementArray,
                                        LinkedList<String> elemheirarchy, Map<String, Object> values){
        String customFiledHeirarchy = elemheirarchy.stream().collect(Collectors.joining("-"));
        for(int elemInx =0; elemInx < elementArray.length(); elemInx++){
            var customElement = (JSONObject) elementArray.get(elemInx);
            values.put(customFiledHeirarchy +"_" +(elemInx +1) + "-"+ customElement.optString("group"),
                    customElement.optString("value"));
        }
        elemheirarchy.removeLast();
    }
}
