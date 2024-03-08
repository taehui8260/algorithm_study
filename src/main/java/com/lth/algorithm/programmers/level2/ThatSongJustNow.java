package com.lth.algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThatSongJustNow {
    public static void main(String[] args) {
        ThatSongJustNow taThatSongJustNow = new ThatSongJustNow();
        System.out.println(taThatSongJustNow.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    /**
     * 방금 그곡
     * <p>
     * 4개씩 끊어서 곡에 대한 정보가 들어있다
     * 곡 시작시간 / 곡 종료시간 / 곡 이름 / 곡 내용
     * 곡은 시작시간부터 종료시간까지 반복해서 계속 나온다
     * 문자열 m은 기억한 곡의 정보가 들어있다.
     * 모든 곡 정보를 곡에 재생된 음악 정보를 추가해 곡 정보 Class 에 추가한다.
     * 기억한 곡의 정보가 재생된 곡 정보에 포함된다면 해당 곡에 대한 정보 List에 넣고 가장 긴 재생시간을 저장한다.
     * 만약 값이 어러개라면 재생 시간이 가장 긴 음악을 반환한다.
     * 이래도 값이 여러개라면 0번째 곡을 보여준다.
     *
     * @param m
     * @param musicinfos
     * @return
     */
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = 0;
        List<MusicInfo> musicInfoList = new LinkedList<>();

        List<MusicInfo> constainMList = new LinkedList<>();

        List<MusicInfo> maxPlayTimeList = new LinkedList<>();

        for (String musicinfo : musicinfos) {
            String[] music = musicinfo.split(",");
            MusicInfo musicInfo = new MusicInfo(music[0], music[1], music[2], music[3]);
            musicInfoList.add(musicInfo);
        }

        for (MusicInfo musicInfo : musicInfoList) {
            /*System.out.println(musicInfo.getMusicPlayTime());
            System.out.println(musicInfo.getMusicName());
            System.out.println(musicInfo.getMusicPlayContents());*/
            if (musicInfo.getMusicPlayContents().contains(m)) {
                for(int i=0; i< musicInfo.getMusicPlayContents().length() - m.length() +1 ; i++){
                    if(musicInfo.getMusicPlayContents().startsWith(m, i)){
                        if(i ==( musicInfo.getMusicPlayContents().length() - m.length()) ){
                            maxPlayTime = Math.max(maxPlayTime, musicInfo.getMusicPlayTime());
                            constainMList.add(musicInfo);
                        }
                        else if(musicInfo.getMusicPlayContents().charAt(i + m.length()) != '#'){
                            maxPlayTime = Math.max(maxPlayTime, musicInfo.getMusicPlayTime());
                            constainMList.add(musicInfo);
                            break;
                        }
                        i += m.length() - 1;
                    }
                }

            }
        }
        if (constainMList.size() == 0) {
            return "(None)";
        } else if (constainMList.size() == 1) {
            return constainMList.get(0).getMusicName();
        } else {
            for (MusicInfo musicInfo : constainMList) {
                if (musicInfo.getMusicPlayTime() == maxPlayTime) {
                    maxPlayTimeList.add(musicInfo);
                }
            }
        }
        return maxPlayTimeList.get(0).getMusicName();
    }

    class MusicInfo {
        private int musicPlayTime;

        private String musicName;

        private String musicPlayContents;

        MusicInfo(String startTime, String endTime, String musicName, String musicContents) {
            this.musicPlayTime = setMusicPlayTime(startTime, endTime);
            this.musicName = musicName;
            this.musicPlayContents = setMusicPlayContents(this.musicPlayTime, musicContents);
        }

        int getMusicPlayTime() {
            return musicPlayTime;
        }

        String getMusicName() {
            return musicName;
        }

        String getMusicPlayContents() {
            return musicPlayContents;
        }

        int setMusicPlayTime(String startTime, String endTime) {
            return changeMinute(endTime) - changeMinute(startTime);
        }

        String setMusicPlayContents(int musicPlayTime, String musicPlayContents) {

            StringBuilder result = new StringBuilder();
            List<String> playContentsList = new ArrayList<>();

            for (int i = 0; i < musicPlayContents.length(); i++) {
                String temp;
                if ('#' == musicPlayContents.charAt(i)) {
                    temp = String.valueOf(musicPlayContents.charAt(i - 1)) +  String.valueOf(musicPlayContents.charAt(i));
                    playContentsList.remove(playContentsList.size() - 1);
                    playContentsList.add(temp);
                } else {
                    playContentsList.add(String.valueOf(musicPlayContents.charAt(i)));
                }
            }
            int index = 0;
            for (int i = 0; i < musicPlayTime; i++) {
                while (index > playContentsList.size() - 1) {
                    index = index - playContentsList.size();
                }
                result.append(playContentsList.get(index));
                ++index;
            }
            return String.valueOf(result);
        }
    }
    /**
     * 00:00 형식의 시간을 분으로 변환
     *
     * @param time
     * @return
     */
    int changeMinute(String time) {
        int minute;

        String[] timeAry = new String[2];
        timeAry = time.split(":");
        minute = Integer.parseInt(timeAry[0]) * 60;
        minute += Integer.parseInt(timeAry[1]);
        return minute;
    }
}
