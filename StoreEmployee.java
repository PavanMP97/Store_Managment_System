package storedbms;

public class StoreEmployee {

private String eName;
private int id=1;
private int password;

public String geteName() {
	return eName;
}
public void seteName(String eName) {
	this.eName = eName;
}
public Integer getId() {
	return id;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public StoreEmployee(String eName, int id, int password) {
	this.eName = eName;
	this.id = id;
	this.password = password;
}
@Override
public String toString() {
	return "eName=" + eName + "\tid=" + id + "\tpassword=" + password;
}

}
