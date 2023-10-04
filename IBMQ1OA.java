import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getFinalData' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY data
     *  2. 2D_INTEGER_ARRAY updates
     */

    public static List<Integer> getFinalData(List<Integer> data, List<List<Integer>> updates) {
        HashMap<Integer, Integer> hm = new HashMap();
        int initial = 0;
        int after = 0;
        for(int i = 0;i<=updates.size()-1;i++){
            for(int j = 0;j<=updates.get(i).size()-1;j++){
                if(j == 0){
                    initial = updates.get(i).get(j);
                }
                else{
                    after = updates.get(i).get(j);
                }
            }
            for(int m = initial; m<=after;m++){
                if(hm.containsKey(m)){
                    hm.put(m , hm.get(m) + 1);
                }
                else{
                    hm.put(m , 1);
                }
            }
        }
        for(int index : hm.keySet()){
            if(hm.get(index) % 2 != 0){
                data.set(index - 1, data.get(index - 1) * -1);
            }
        }
        return data;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int dataCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = IntStream.range(0, dataCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int updatesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int updatesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> updates = new ArrayList<>();

        IntStream.range(0, updatesRows).forEach(i -> {
            try {
                updates.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.getFinalData(data, updates);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
