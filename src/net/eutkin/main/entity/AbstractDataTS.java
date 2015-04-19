package net.eutkin.main.entity;

import java.util.Date;


public abstract class AbstractDataTS {

    private Integer ts_id;

    private Date timeMensuration;

    private Date dateMensuration;

    private Integer meter_id;

    private Double voltage;

    private Double the_current;

    private Double power;

    private Double given_energy;

    private Double accepted_energy;

    public void setRec_id(Integer ts_id) {this.ts_id = ts_id;}
    public Integer getRec_id() {return ts_id;}

    public void setTimeMensuration(Date date) {this.timeMensuration = date;}
    public Date getTimeMensuration() {return timeMensuration;}

    public void setVoltage(Double voltage) {this.voltage = voltage;}
    public Double getVoltage() {return voltage;}

    public void setThe_current(Double the_current) {this.the_current = the_current;}
    public Double getThe_current() {return the_current;}

    public void setPower(Double power) {this.power = power;}
    public Double getPower() {return power;}

    public void setGiven_energy(Double given_energy) {this.given_energy = given_energy;}
    public Double getGiven_energy() {return given_energy;}

    public void setAccepted_energy(Double accepted_energy) {this.accepted_energy = accepted_energy;}
    public Double getAccepted_energy() {return accepted_energy;}

    public Date getDateMensuration() {
        return dateMensuration;
    }

    public void setDateMensuration(Date dateMensuration) {
        this.dateMensuration = dateMensuration;
    }

    public Integer getMeter_id() {
        return meter_id;
    }

    public void setMeter_id(Integer meter_id) {
        this.meter_id = meter_id;
    }
}
