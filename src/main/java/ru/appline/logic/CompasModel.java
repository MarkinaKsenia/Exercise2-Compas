package ru.appline.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CompasModel {
    public static final CompasModel instanse = new CompasModel();
    private final Map<String, CompasNew> model;
    private Collection<String> collection ;
    private Map<String, String> answer ;

    public CompasModel(){
        model=new HashMap<String, CompasNew>();
        answer = new HashMap<String, String>();
        collection = model.keySet();
    }

    public static CompasModel getInstance() {
        return instanse;
    }

    public void add(Map<String, CompasNew> map){
        model.putAll(map);
    }

    public Map<String, CompasNew> getAll(){
        return model;
    }

    public Map<String, String> getFromList(int degree){
        if (degree<=360 && degree >=0){
            String count="";
            for(String key: collection){
                CompasNew cmp = model.get(key);
                if(key != null) {
                    if(!key.equals("North")){
                        if(cmp.getStart() <= degree && cmp.getEnd()>=degree) {
                            answer.put("Side"+count, key);
                            count+="Side";
                        }
                    }
                    else {
                        if(cmp.getStart() <= degree || cmp.getEnd()>=degree) {
                            answer.put("Side"+count, key);
                            count+="Side";
                        }
                    }

                }
            }
        }
        else {
            answer.clear();
            answer.put("Неверно введены градусы","Значения градусов должны быть от 0 до 360");
        }
        return answer;
    }
}

// Выполнила Маркина Ксения
