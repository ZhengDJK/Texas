package com.zheng.poker.texas.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 2016/10/11.
 */
public class Poker {
    private Color color;
    private int point = 2;
    private boolean flag=true;
    private volatile static List<Poker> pokers;


    public Poker(Color color, int point) {
        this.setColor(color);
        try {
            this.setPoint(point);
        } catch (PokerException e) {
            e.printStackTrace();
        }
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

    public void setPoint(int point) throws PokerException {
        if (point < 2 || point > 14)
            throw new PokerException("The point out of bound!");
        this.point = point;
    }

    public static List<Poker> getAllPoker() {
        List<Poker> allPoker = new ArrayList<Poker>();
        for (int i = 2; i < 15; i++) {
            for (Color color : Color.values()) {
                allPoker.add(new Poker(color, i));
            }
        }
        return allPoker;
    }


    public static List<Poker> getPokers() {
        if (pokers == null) {
            synchronized (Poker.class) {
                if (pokers == null) {
                    pokers = getAllPoker();
                }
            }
        }
        return pokers;
    }

    @Override
    public String toString() {
        return this.color.toString() + " " + point;
    }

    public int getIndex() {
        return (this.point - 2) * 4 + this.color.ordinal();
    }

    public Poker getPokerByIndex(int index){
        return getPokers().get(index);
    }
}
