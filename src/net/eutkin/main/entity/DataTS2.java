package net.eutkin.main.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "data_ts2")
public class DataTS2 extends AbstractDataTS {
    @Id
    @Column(name = "ts_id")
    @SequenceGenerator(name = "data_ts2_seq", sequenceName = "data_ts2_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_ts2_seq")
    @NotNull
    private Integer ts_id;

    @Column(name = "time_mensuration")
    @NotNull
    private Date timeMensuration;

    @Column(name = "date_mensuration")
    @NotNull
    private Date dateMensuration;

    @Column(name = "meter_id")
    @NotNull
    private Integer meter_id;

    @Column(name = "voltage")
    private Double voltage;

    @Column(name = "the_current")
    private Double the_current;

    @Column(name = "power")
    private Double power;


    @Column(name = "given_energy")
    private Double given_energy;


    @Column(name = "accepted_energy")
    private Double accepted_energy;

    public void setTs_id(Integer ts_id) {this.ts_id = ts_id;}
    public Integer getTs_id() {return ts_id;}

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
