package com.lth.algorithm.programmers;

import java.util.*;

public class FileNameSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"aimG.12.2.JPG", "img12.png", "A10.png", "img02.png", "img1.png", "IMG01.GIF", "aimg.12.2.JPG"})));
    }
    //숫자를 기준으로 나오기 전 까지를 Head, 숫자를 Number, 뒤를 Tail 로 구분
    public static String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            FileInfo file1 = new FileInfo(o1);
            FileInfo file2 = new FileInfo(o2);
            int headCompare = file1.head.compareTo(file2.head);
            int numCompare = file1.num - file2.num;

            if(headCompare == 0){
                if(numCompare == 0){
                    return 0;
                } else{
                    return numCompare;
                }

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

        int index;
        FileInfo(String fileFullName){
            this.fileFullName = fileFullName;
            for(int i=0; i<fileFullName.length(); i++){
                if(this.index == 0 && Character.isDigit(fileFullName.charAt(i))){
                    this.index = i;
                    this.head =  fileFullName.substring(0, i).toUpperCase();
                }
                if(this.index !=0 && !Character.isDigit(fileFullName.charAt(i))){
                    this.num = Integer.parseInt(fileFullName.substring(this.index, i));
                    break;
                }
            }
        }
    }
}
