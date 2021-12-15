package service;

import model.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryService {
    private static Map<Integer, Dictionary> dicTion = new HashMap<>();

    static {
        dicTion.put(1, new Dictionary("hello", "xin chào"));
        dicTion.put(2, new Dictionary("bye", "tạm biệt"));
        dicTion.put(3, new Dictionary("house", "ngôi nhà"));
    }

    public List<Dictionary> findAll() {
        return new ArrayList<>(dicTion.values());
    }
}
