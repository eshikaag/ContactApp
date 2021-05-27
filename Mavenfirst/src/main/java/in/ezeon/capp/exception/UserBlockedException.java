package in.ezeon.capp.exception;

public class UserBlockedException extends Exception {
public UserBlockedException()
{
//creTES USER OBJ W/O ERR DESCR	
}
public UserBlockedException(String errDescr) {
super(errDescr);
//creTES USER OBJ WITH ERR DESCR	
}
}

