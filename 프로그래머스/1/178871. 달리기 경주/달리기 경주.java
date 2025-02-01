import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String,Integer> ranking = new HashMap<>();
        
        for (int i = 0;i < players.length;i++) {
            ranking.put(players[i], i);
        }
        
        for (String player : callings) {
            int playerRank = ranking.get(player);
            
            String frontPlayer = players[playerRank - 1];
            
            ranking.replace(frontPlayer, playerRank);
            players[playerRank] = frontPlayer;
            
            ranking.replace(player, playerRank-1);
            players[playerRank-1] = player;
        }
        
        return players;
    }
}