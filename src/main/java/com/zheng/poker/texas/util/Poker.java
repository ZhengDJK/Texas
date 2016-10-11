package com.zheng.poker.texas.util;

/**
 * Created by DJ on 2016/10/11.
 */
public class Poker {
    private Color color;
    private int point;

    public Poker(Color color,int point){
        this.setColor(color);
        this.setPoint(point);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
