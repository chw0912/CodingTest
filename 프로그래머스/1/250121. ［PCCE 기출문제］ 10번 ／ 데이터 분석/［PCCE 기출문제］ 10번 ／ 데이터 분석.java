import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int filterIndex = indexTranslator(ext);
        
        
        return Arrays.stream(data).filter(x -> x[filterIndex] < val_ext).sorted((o1, o2) -> o1[indexTranslator(sort_by)] - o2[indexTranslator(sort_by)]).toArray(int[][]::new);
    }
    
    private int indexTranslator(String ext) {
        switch (ext) {
            case "code" : return 0;
            case "date" : return 1;
            case "maximum" : return 2;
            default : return 3;
        }
    }
}