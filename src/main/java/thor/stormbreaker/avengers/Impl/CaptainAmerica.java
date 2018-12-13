package thor.stormbreaker.avengers.Impl;

import thor.stormbreaker.avengers.Avenger;

public class CaptainAmerica implements Avenger {
    private String name;
    private String power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void highlightSpecialPower() {
        System.out.println("Avenger Name: "+name+"\nPower: "+power);
        System.out.println("Captain America had experimental treatments in World War Two, " +
                "which made his muscle tissue not only increase but become more efficient");
    }
}
