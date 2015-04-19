package net.eutkin.main.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ts_meters")
public class TsMeters extends AbstractDataTS {
    @Id
    @Column(name = "tsm_id")
    @SequenceGenerator(name = "ts_meters_tsm_id_seq", sequenceName = "ts_meters_tsm_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ts_meters_tsm_id_seq")
    @NotNull
    private Integer tsm_id;

    @Column(name = "tsm_ip_addr4")
    @NotNull
    private int tsmIpAddr4;

    @Column(name = "tsm_ip_addr3")
    @NotNull
    private int tsmIpAddr3;

    @Column(name = "tsm_ip_addr2")
    @NotNull
    private int tsmIpAddr2;

    @Column(name = "tsm_ip_addr1")
    private int tsmIpAddr1;

    @Column(name = "tsm_mac_addr")
    private String tsmMacAddr;

    @Column(name = "tsm_kind")
    private int tsmKind;


    @Column(name = "tsm_comment")
    private String tsmComment;


    public Integer getTsm_id() {
        return tsm_id;
    }

    public void setTsm_id(Integer tsm_id) {
        this.tsm_id = tsm_id;
    }

    public int getTsmIpAddr4() {
        return tsmIpAddr4;
    }

    public void setTsmIpAddr4(int tsmIpAddr4) {
        this.tsmIpAddr4 = tsmIpAddr4;
    }

    public int getTsmIpAddr3() {
        return tsmIpAddr3;
    }

    public void setTsmIpAddr3(int tsmIpAddr3) {
        this.tsmIpAddr3 = tsmIpAddr3;
    }

    public int getTsmIpAddr2() {
        return tsmIpAddr2;
    }

    public void setTsmIpAddr2(int tsmIpAddr2) {
        this.tsmIpAddr2 = tsmIpAddr2;
    }

    public int getTsmIpAddr1() {
        return tsmIpAddr1;
    }

    public void setTsmIpAddr1(int tsmIpAddr1) {
        this.tsmIpAddr1 = tsmIpAddr1;
    }

    public String getTsmMacAddr() {
        return tsmMacAddr;
    }

    public void setTsmMacAddr(String tsmMacAddr) {
        this.tsmMacAddr = tsmMacAddr;
    }

    public int getTsmKind() {
        return tsmKind;
    }

    public void setTsmKind(int tsmKind) {
        this.tsmKind = tsmKind;
    }

    public String getTsmComment() {
        return tsmComment;
    }

    public void setTsmComment(String tsmComment) {
        this.tsmComment = tsmComment;
    }
}
