package hash;

import java.util.Map;
import java.util.HashMap;

public class FailedGoal {
    public static void main(String[] args) {
        if(scoring()){
            System.out.println("통과");
        }
        return;
    }

    protected static String solution(String[] participant, String[] completion) {
        Map<String, Integer> hash = new HashMap<String, Integer>();
        String answer = "";

        for (int i = 0; i < participant.length; i++) {
            String key = participant[i];
            if (hash.size() != 0) {   //값이 존재한다
                if (hash.containsKey(key)) {  //키가 존재한다
                    hash.replace(key, hash.get(key) + 1);  //이미 있는 키 + 1
                } else {    //키가 존재하지 않는다
                    hash.put(key, 1);
                }
            } else {    //값이 존재하지 않는다
                hash.put(key, 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            String key = completion[i];
            if (hash.containsKey(key)) {  //키가 존재한다
                if (hash.get(key) - 1 > 0) {   //동명n인일 경우, hash에서 1을 뺀다.
                    hash.replace(key, hash.get(key) - 1);
                } else {
                    hash.remove(key);
                }
            }
        }

        answer = (hash.keySet().toArray())[0].toString();
        return answer;
    }

    protected static boolean scoring(){
        boolean success = true;
        //test case 1
        String[] participant_1 = {"leo", "kiki", "eden"};
        String[] completion_1 = {"eden", "kiki"};
        String answer_1 = "leo";
        if(!solution(participant_1,completion_1).equals(answer_1)) success = false;

        //test case 2
        String[] participant_2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion_2 = {"josipa", "filipa", "marina", "nikola"};
        String answer_2 = "vinko";
        if(!solution(participant_2,completion_2).equals(answer_2)) success = false;

        //test case 3
        String[] participant_3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion_3 = {"stanko", "ana", "mislav"};
        String answer_3 = "mislav";
        if(!solution(participant_3,completion_3).equals(answer_3)) success = false;

        return success;
    }

    //출처 : https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
}
