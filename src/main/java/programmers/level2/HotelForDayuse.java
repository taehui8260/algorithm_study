package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelForDayuse {
    public static void main(String[] args) {
        HotelForDayuse hotelForDayuse = new HotelForDayuse();
        System.out.println(hotelForDayuse.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }

    /**
     * 호텔 대실
     *
     *  시작시간을 기준으로 정렬한다.
     *  방 목록을 List 형태의 Collection 에 저장한다.
     *  방 목록이 없을때에 가장 시작시간이 빠른 예약의 종료시간을 방 목록에 넣는다.
     *  예약을 처음부터 끝까지 반복하면서 방 목록에 적혀있는 시간보다 시작시간이 10 크다면 그 방에 예약 종료시간을 넣는다.
     *  만약 끝까지 방을 확인 했지만 방이 없다면 방을 추가한다.
     *  input [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
     *  result 3
     *
     * @param book_time
     * @return
     */
    //
    public int solution(String[][] book_time) {
        List<Integer> roomList = new ArrayList<>();
        Arrays.sort(book_time, (o1, o2) -> changeMinute(o1[0]) - changeMinute(o2[0]));


        roomList.add(changeMinute(book_time[0][1]));

        int listSize = 1;
        for(int j=1; j<book_time.length; j++){
            listSize = roomList.size();
            for(int i=0; i<listSize; i++){
                if(roomList.get(i) + 10 <= changeMinute(book_time[j][0])){
                    roomList.set(i, changeMinute(book_time[j][1]));
                    break;
                }


                if(i == listSize-1){
                    roomList.add(changeMinute(book_time[j][1]));
                }
            }
        }

        return roomList.size();
    }

    //00:00 형태의 시간을 분으로 변경
    int changeMinute(String time){
        int minute;

        String [] timeAry = new String[2];
        timeAry = time.split(":");
        minute = Integer.parseInt(timeAry[0]) * 60;
        minute += Integer.parseInt(timeAry[1]);
        return minute;
    }
}
