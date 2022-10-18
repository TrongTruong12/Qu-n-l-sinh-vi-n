package model;

import java.util.Date;

public class Detai {
	private String madetai;
	private String tendetai,yeucau;
	private Date deadline;
	private int trangthainop;
	private String nhomdangki;
	public String getMadetai() {
		return madetai;
	}
	public void setMadetai(String madetai) {
		this.madetai = madetai;
	}
	public String getTendetai() {
		return tendetai;
	}
	public void setTendetai(String tendetai) {
		this.tendetai = tendetai;
	}
	public String getYeucau() {
		return yeucau;
	}
	public void setYeucau(String yeucau) {
		this.yeucau = yeucau;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getNhomdangki() {
		return nhomdangki;
	}
	public void setNhomdangki(String nhomdangki) {
		this.nhomdangki = nhomdangki;
	}
	public int getTrangthainop() {
		return trangthainop;
	}
	public void setTrangthainop(int trangthainop) {
		this.trangthainop = trangthainop;
	}
	public Detai(String madetai, String tendetai, String yeucau, Date deadline, String nhomdangki, int trangthainop) {
		super();
		this.madetai = madetai;
		this.tendetai = tendetai;
		this.yeucau = yeucau;
		this.deadline = deadline;
		this.nhomdangki = nhomdangki;
		this.trangthainop = trangthainop;
	}
	public Detai() {
		super();
	}
	
	
    
 
}