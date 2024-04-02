package algorithm.training.five.lesson.one.complexity.testing.special.cases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class J_FormattingTheDocument {
    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        List<Image> images = new ArrayList<>();
        DateString dateString = inputData(words, images);
        Set<SurroundedImage> surroundedImages = new HashSet<>();

        long xNextFloating = 0, yNextFloating = 0;

        boolean isAddSpace = false;
        boolean isPrevFloating = false;
        int indexImages = 0;
        for (int i = 0; i < words.size(); i++) {
            if (!words.get(i).equals("()")){
                isPrevFloating = false;
                if (words.get(i).equals("\n")) {
                    dateString.x = 0;
                    dateString.y += dateString.h;
                    dateString.changeY();
                    isAddSpace = false;
                    continue;
                }
                long lenWords = words.get(i).length() * dateString.c;
                if (isAddSpace && dateString.x != 0) lenWords += dateString.c;
                while (true) {
                    if ((dateString.x + lenWords) <= dateString.lenLine) {
                        dateString.x += lenWords;
                        isAddSpace = true;
                        break;
                    } else {
                        if (isAddSpace) lenWords -= dateString.c;
                        isAddSpace = false;
                        dateString.x = dateString.lenLine;
                        dateString.searchPosition(surroundedImages, false);
                        }
                    }
            }else {
                Image image = images.get(indexImages);
                if (image.layout.equals("embedded")){
                    isPrevFloating = false;
                    if (isAddSpace && dateString.x != 0) dateString.x += dateString.c;
                    isAddSpace = true;

                    findPositionFromImage(dateString, image, surroundedImages);

                    System.out.println(dateString.x + " " + dateString.y);
                    dateString.x += image.wight;
                    dateString.searchPosition(surroundedImages, true);
                    if (image.height > dateString.h && (dateString.y + image.height) > dateString.changeHeight) dateString.changeHeight = dateString.y + image.height;
                }else if (image.layout.equals("surrounded")){
                    isAddSpace = false;
                    isPrevFloating = false;
                    DateString cloneDataString = dateString.clone();

                    findPositionFromImage(cloneDataString, image, surroundedImages);

                    System.out.println(cloneDataString.x + " " + cloneDataString.y);
                    surroundedImages.add(new SurroundedImage(cloneDataString.x, cloneDataString.x + image.wight,
                            cloneDataString.y, cloneDataString.y + image.height));
                    if (cloneDataString.x == dateString.x && cloneDataString.y == dateString.y) dateString.x += image.wight;
                    dateString.searchPosition(surroundedImages, true);
                } else if (image.layout.equals("floating")){
                    long floatingX = dateString.x, floatingY = dateString.y;
                    if (isPrevFloating){
                        floatingY = yNextFloating;
                        floatingX = xNextFloating;
                    }

                    floatingY += image.dy;
                    floatingX += image.dx;

                    if (floatingX < 0) floatingX = 0;
                    if (floatingX + image.wight > dateString.w) floatingX -= (floatingX + image.wight - dateString.w);

                    System.out.println(floatingX + " " + floatingY);

                    yNextFloating = floatingY;
                    xNextFloating = floatingX + image.wight;
                    isPrevFloating = true;
                }
                indexImages++;
            }
        }
    }

    public static void findPositionFromImage(DateString dateString, Image image, Set<SurroundedImage> surroundedImages){
        boolean isFreeBottom = false;
        boolean isFreeRight = dateString.x + image.wight <= dateString.lenLine;
        while (!isFreeBottom || !isFreeRight) {
            isFreeBottom = true;
            if (!isFreeBottom || !isFreeRight) {
                dateString.x = dateString.lenLine;
                dateString.searchPosition(surroundedImages, false);
            }

            for (SurroundedImage img : surroundedImages) {
                if (img.startY < dateString.y + image.height && img.startY > dateString.y &&
                        ((img.startX <= dateString.y && img.endX > dateString.y) ||
                                (img.startX > dateString.y && img.startX < dateString.y + image.wight))){
                    isFreeBottom = false;
                }
            }
            isFreeRight = dateString.x + image.wight <= dateString.lenLine;
        }
    }

    public static DateString inputData(List<String> words, List<Image> images) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String in[] = reader.readLine().split(" ");
        DateString dateString = new DateString(Long.parseLong(in[0]), Long.parseLong(in[1]), Long.parseLong(in[2]));

        String line;
        String lines = "";
        while ((line = reader.readLine()) != null){
            lines += line;
            if(lines.length() == 0){
                words.add("\n");
                continue;
            }
            int startImages;
            int endImages;
            while ((startImages = lines.indexOf("(")) >= 0){
                while ((endImages = lines.indexOf(")", startImages)) < 0){
                    lines += " " + reader.readLine();
                }

                String[] strImage = lines.substring(startImages + 6, endImages).split(" ");
                String startWords = lines.substring(0, startImages);
                if (startWords.length() > 0) words.addAll(List.of(startWords.split(" ")));
                if (lines.substring(endImages + 1).length() > 0){
                    lines = lines.substring(endImages + 2);
                }else lines = "";
                words.add("()");
                long wight = 0, height = 0;
                String layout = "";
                long dx = 0, dy = 0;
                for (int j = 0; j < strImage.length; j++){
                    String[] param = strImage[j].split("=");
                    if (param[0].equals("width")){
                        wight = Integer.parseInt(param[1]);
                    }else if (param[0].equals("height")){
                        height = Integer.parseInt(param[1]);
                    }else if (param[0].equals("layout")){
                        layout = param[1];
                    }else if (param[0].equals("dx")){
                        dx = Integer.parseInt(param[1]);
                    }else if (param[0].equals("dy")){
                        dy = Integer.parseInt(param[1]);
                    }
                }
                images.add(new Image(wight, height, layout, dx, dy));
            }
            if (lines.length() > 0) words.addAll(List.of(lines.split(" ")));
            lines = "";
        }
        return dateString;
    }
}

class DateString{
    long x;
    long y;
    long h;
    long w;
    long c;
    long lenLine;
    long changeHeight;

    public DateString(long w, long h, long c) {
        this.x = 0;
        this.y = 0;
        this.h = h;
        this.w = w;
        this.c = c;
        this.lenLine = w;
        this.changeHeight = 0;
    }

    public DateString(long x, long y, long h, long w, long c, long lenLine, long changeHeight) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.c = c;
        this.lenLine = lenLine;
        this.changeHeight = changeHeight;
    }

    public void changeY(){
        if (changeHeight > 0){
            y = changeHeight;
            changeHeight = 0;
        }
    }

    public DateString clone(){
        return new DateString(x, y, h, w, c, lenLine, changeHeight);
    }

    public void searchPosition(Set<SurroundedImage> surroundedImages, boolean isSuitEndLine){
        while (true) {
            searchX(surroundedImages, isSuitEndLine);
            if (x < lenLine || (isSuitEndLine && x <= lenLine)) break;
            y += h;
            changeY();
            x = 0;
            lenLine = w;
        }
    }

    private void searchX(Set<SurroundedImage> surroundedImages, boolean isSuitEndLine){
        long minX = -1;
        long nextLine = x + h;
        if (changeHeight > 0) nextLine = changeHeight;
        while (minX != x) {
            minX = x;
            for (SurroundedImage img : surroundedImages) {
                if (((img.startY <= y && img.endY > y) || (img.startY >= y && img.startY < nextLine)) && ((img.startX <= x && !isSuitEndLine) || img.startX < x) && img.endX > x) {
                    x = img.endX;
                }
            }
        }

        searchLenLine(surroundedImages);
    }

    private void searchLenLine(Set<SurroundedImage> surroundedImages){
        lenLine = w;
        long minLenLine = -1;
        long nextLine = x + h;
        if (changeHeight > 0) nextLine = changeHeight;
        while (minLenLine != lenLine){
            minLenLine = lenLine;
            for (SurroundedImage img : surroundedImages) {
                if (((img.startY <= y && img.endY > y) || (img.startY >= y && img.startY < nextLine)) && img.startX >= x && img.startX < lenLine) {
                    lenLine = img.startX;
                }
            }
        }
    }
}

class SurroundedImage{
    long startX;
    long endX;
    long startY;
    long endY;

    public SurroundedImage(long startX, long endX, long startY, long endY) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }
}

class Image{
    long wight;
    long height;
    String layout;
    long dx;
    long dy;

    public Image(long wight, long height, String layout, long dx, long dy) {
        this.wight = wight;
        this.height = height;
        this.layout = layout;
        this.dx = dx;
        this.dy = dy;
    }
}