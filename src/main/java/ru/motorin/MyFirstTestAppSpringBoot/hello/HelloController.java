package ru.motorin.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    private ArrayList<String> myArrayList;
    private HashMap<Integer, String> myHashMap;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "element",
            defaultValue = "empty_element") String element) {
        if (myArrayList == null) {
            myArrayList = new ArrayList<>();
        } else {
            myArrayList.add(element);
        }
        return "success";
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        return myArrayList.toString();
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "keyvalue",
            defaultValue = "0,default_element") String keyvalue) {
        if (myHashMap == null) {
            myHashMap = new HashMap<>();
        } else {
            String[] words = keyvalue.split(",");
            myHashMap.put(Integer.parseInt(words[0]), words[1]);
        }
        return "success";
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return myHashMap.toString();
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        return String.format("myArrayList length is %d\nmyHashMap length is %d",
                myArrayList.size(), myHashMap.size());
    }
}
