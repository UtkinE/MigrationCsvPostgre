package net.eutkin.main.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "data_ts1")
public class DataTS1 extends AbstractDataTS {
    @Id
    @Column(name = "ts_id")
    @SequenceGenerator(name = "data_ts1_seq", sequenceName = "data_ts1_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_ts1_seq")
    @NotNull
    /** Field Entity. Primary key of table */
    private Integer rec_id;

    @Column(name = "time_mensuration")
    @NotNull
    /** Field Entity. Time of mensuration */
    private Date timeMensuration;

    @Column(name = "date_mensuration")
    @NotNull
    /** Field Entity. Date of mensuration */
    private Date dateMensuration;

    @Column(name = "meter_id")
    @NotNull
    /** Field Entity. Unique id of meter on traction substantion */
    private Integer meter_id;

    @Column(name = "voltage")
    /** Field Entity. Voltage */
    private Double voltage;

    @Column(name = "the_current")
    /** Field Entity. The current */
    private Double the_current;

    @Column(name = "power")
    /** Field Entity. Power */
    private Double power;

    @Column(name = "given_energy")
    /* Field Entity. Given energy */
    private Double given_energy;

    @Column(name = "accepted_energy")
    /** Field Entity. Accepted energy */
    private Double accepted_energy;

    /**
     * setter for field rec_id
     * @param rec_id
     */
    public void setRec_id(Integer rec_id) {this.rec_id = rec_id;}

    /**
     * getter for field rec_id
     * @return
     */
    public Integer getRec_id() {return rec_id;}

    /**
     * setter for field timeMensuration
     * @param date
     */
    public void setTimeMensuration(Date date) {this.timeMensuration = date;}

    /**
     * getter for field timeMensuration
     * @return
     */
    public Date getTimeMensuration() {return timeMensuration;}

    /**
     * setter for field dateMensuration
     * @param dateMensuration
     */
    public void setDateMensuration(Date dateMensuration) { this.dateMensuration = dateMensuration; }

    /**
     * getter for field dateMensuration
     * @return
     */
    public Date getDateMensuration() { return dateMensuration; }

    /**
     * setter for field meter_id
     * @param meter_id
     */
    public void setMeter_id(Integer meter_id) { this.meter_id = meter_id; }

    /**
     * getter for field meter_id
     * @return
     */
    public Integer getMeter_id() { return meter_id; }

    /**
     * setter for field voltage
     * @param voltage
     */
    public void setVoltage(Double voltage) {this.voltage = voltage;}

    /**
     *  getter for field voltage
     * @return
     */
    public Double getVoltage() {return voltage;}

    /**
     * setter for field the_current
     * @param the_current
     */
    public void setThe_current(Double the_current) {this.the_current = the_current;}

    /**
     *  getter for field the_current
     * @return
     */
    public Double getThe_current() {return the_current;}

    /**
     * setter for field power
     * @param power
     */
    public void setPower(Double power) {this.power = power;}

    /**
     *  getter for field power
     * @return
     */
    public Double getPower() {return power;}

    /**
     * setter for field given_energy
     * @param given_energy
     */
    public void setGiven_energy(Double given_energy) {this.given_energy = given_energy;}

    /**
     *  getter for field given_energy
     * @return
     */
    public Double getGiven_energy() {return given_energy;}

    /**
     * setter for field accepted_energy
     * @param accepted_energy
     */
    public void setAccepted_energy(Double accepted_energy) {this.accepted_energy = accepted_energy;}

    /**
     *  getter for field accepted_energy
     * @return
     */
    public Double getAccepted_energy() {return accepted_energy;}



}
