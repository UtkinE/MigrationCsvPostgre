package net.eutkin.main.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "data_day")
public class DataTS1 {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "data_day_seq", sequenceName = "data_day_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_day_seq")
    @NotNull
    private Integer id;

    @Column(name = "time_mensuration")
    @NotNull
    private Date timeMensuration;

    @Column(name = "voltage")
    private Double column1;

    @Column(name = "the_current")
    private Double column2;

    @Column(name = "power")
    private Double column3;


    @Column(name = "given_energy")
    private Double column4;


    @Column(name = "accepted_energy")
    private Double column5;

    public void setId(Integer id) {this.id = id;}
    public Integer getId() {return id;}

    public void setTimeMensuration(Date date) {this.timeMensuration = date;}
    public Date getTimeMensuration() {return timeMensuration;}

    public void setColumn1(Double column1) {this.column1 = column1;}
    public Double getColumn1() {return column1;}

    public void setColumn2(Double column2) {this.column2 = column2;}
    public Double getColumn2() {return column2;}

    public void setColumn3(Double column3) {this.column3 = column3;}
    public Double getColumn3() {return column3;}

    public void setColumn4(Double column4) {this.column4 = column4;}
    public Double getColumn4() {return column4;}

    public void setColumn5(Double column5) {this.column5 = column5;}
    public Double getColumn5() {return column5;}

}
