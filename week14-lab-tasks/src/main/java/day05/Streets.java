package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Streets {
    private Map<String, List<Integer>> streetsMap = new HashMap<>();

    @Override
    public String toString() {
        return streetsMap.toString();
    }

    public void readFile(Path path){
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String streetName;
            int num;
            while (reader.ready()){
                streetName=reader.readLine().trim();
                num=Integer.parseInt(streetName.substring(streetName.length()-1));
                streetName=streetName.substring(0,streetName.length()-1);
                if (!streetsMap.keySet().contains(streetName)){
                    if (num==0) {
                        streetsMap.put(streetName, new ArrayList<>(Arrays.asList(2)));
                    }else {
                        streetsMap.put(streetName, new ArrayList<>(Arrays.asList(1)));
                    }
                }else {
                    modifyList(streetName,num);
                }
            }
        }catch (IOException e){
            throw new IllegalStateException("Can not read file",e);
        }
    }

    private List<Integer> modifyList(String street,int number){
        List<Integer> result=streetsMap.get(street);
        if (number==0){
            result.add(result.stream().filter(integer -> integer%2==0).max(Integer::compareTo).orElse(0)+2);
        }else {
            result.add(result.stream().filter(integer -> integer%2==1).max(Integer::compareTo).orElse(-1)+2);
        }
        return result;
    }
}
