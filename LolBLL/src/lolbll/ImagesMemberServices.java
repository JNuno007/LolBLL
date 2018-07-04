/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolbll;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author joaoc
 */
public class ImagesMemberServices {
    
    private static Map<String, String> map = new HashMap<>();

    public ImagesMemberServices() {
    }
    
    public static void addToMap(String o, String path){
        if(!map.containsKey(o)){
            map.put(o, path);
        }
        System.out.println(map);
    }
    
    public static boolean existsOnMap(String o){
        boolean exists = false;
        if(map.containsKey(o)){
            exists = true;
        }
        return exists;
    }
    
    public static String getOriginalPath(String o){
        System.out.println(map.get(o));
        return map.get(o);
    }
    
    public static Map<String, String> getMap(){
        return map;
    }
}

