package codegym.com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService{
    static Map<String, String> dicTion = new HashMap<>();

    static {
        dicTion.put("hello", "xin chào");
        dicTion.put("bye", "tạm biệt");
        dicTion.put("house", "ngôi nhà");
    }

    @Override
    public String findAll(String engLish) {
        String result="";
        if(dicTion.get(engLish)==null){
            result = "ERROR";
        } else {
            result = dicTion.get(engLish);
        }
        return result;
    }
}
