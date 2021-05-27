package in.ezeon.capp.util;

public class StringUtil {
//making this static so that no need to create obj and can call this method directly
	public static String toCommaSeparatedString(Object[] obj) {
		String result="";
		  if (obj != null || obj.equals(null)) {
		   if (obj.length > 0) {
		    StringBuilder sb = new StringBuilder();
		    for (Object str : obj) {
		     sb.append(str + " ,");
		    }
		    result = sb.deleteCharAt(obj.length - 1).toString();
		   }
		  }
		  return result;
		 }
}
