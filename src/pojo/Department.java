package pojo;

public class Department {
private int toid;
private String departmentname;
private int managerid;
private String manager;
public int getToid() {
	return toid;
}
public void setToid(int toid) {
	this.toid = toid;
}
public String getDepartmentname() {
	return departmentname;
}
public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}
public int getManagerid() {
	return managerid;
}
public void setManagerid(int managerid) {
	this.managerid = managerid;
}
public void setManager(String manager) {
	this.manager = manager;
}
public String getManager() {
	return manager;
}
}
