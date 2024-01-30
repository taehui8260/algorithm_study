package com.lth.algorithm.programmers;

import java.util.*;

public class FileNameSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"IMG0145.GIF", "aimG.12.2.JPG", "img12.png", "A10.png", "img02.png", "img1.png", "IMG01.GIF", "aimg.12.2.JPG", "a042ss", "a1234", "a2222", "aa2222"})));
    }
    //숫자를 기준으로 나오기 전 까지를 Head, 숫자를 Number, 뒤를 Tail 로 구분
    public static String[] solution(String[] files) {
        FileInfo[] fileInfos = new FileInfo[files.length];
        System.out.println(files.length);

        for(int i=0; i< files.length; i++){
            fileInfos[i] = new FileInfo(files[i]);
            System.out.println();

        }

        Arrays.sort(fileInfos, (o1, o2) -> {
            int headCompare = o1.head.compareTo(o2.head);
            int numCompare = o1.num - o2.num;
            if(headCompare == 0){
                return numCompare;

            } else {
                return headCompare;
            }
        });
        return files;
    }
    static class FileInfo{
        String fileFullName;
        String head;
        int num;

        int startNumIndex;
        int startTailIndex;

        FileInfo(String fileFullName){
            this.fileFullName = fileFullName;
            this.
        }
        String setHead(String fileFullName){
            for(int i=0; i<fileFullName.length(); i++){
                if(Character.isDigit(fileFullName.charAt(i))){
                    this.startNumIndex = i;
                    return fileFullName.substring(0, i).toUpperCase();
                }
            }
            return "";
        }
        int setNum(String fileFullName) {
            int startTailIndex = -1;
            for (int i = this.startNumIndex; i < fileFullName.length(); i++) {
                if (!Character.isDigit(fileFullName.charAt(i))) {
                    if (i - this.startNumIndex > 5) {
                        startTailIndex = this.startNumIndex + 5;
                        return Integer.parseInt(fileFullName.substring(this.startNumIndex, this.startTailIndex + 5));
                    } else {
                        startTailIndex = i;
                        return Integer.parseInt(fileFullName.substring(this.startNumIndex, i));
                    }
                }
            }
            //Tail이 없을경우
            if(fileFullName.substring(this.startNumIndex).length() > 5){
                return Integer.parseInt(fileFullName.substring(this.startNumIndex, this.startNumIndex + 5));
            } else{
                return Integer.parseInt(fileFullName.substring(this.startNumIndex));
            }
        }
    }
}
