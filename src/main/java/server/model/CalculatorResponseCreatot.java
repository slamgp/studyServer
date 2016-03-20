package server.model;


public class CalculatorResponseCreatot extends ResponseCreator{

	@Override
	public String processingParametrs(String []str) {
		String result = "";
		if (str != null){
		    result = "<center><table  border = 2>"
			     	+ "<tr>";
		    for(int i=0; i<str.length; i++) {
			    result = result + "<td  align=center width=50px><h2>" + str[i] + "</h2></td>";
		    }
		    result = result + "</tr>"
			    	+ "</table></center>"
			    	+ "<p></p>";
		};
		return result;
	}

	@Override
	protected String getMainBody() {
		return  "<html><head><title>KOZAK:CALCULATOR</title></head>"
        		+ "<body>"
        		+ "<h3>Available operations</h3>"
        		+ "<p><h4>add - add operands</h4> <a href = /calculator?operation=add&param1=10&param2=2> 10 + 2 example </a></p>"
        		+ "<p><h4>sub - subtraction operands</h4> <a href = /calculator?operation=sub&param1=10&param2=2> 10 - 2 example </a></p>"
        		+ "<p><h4>mul - multiply  operands</h4> <a href = /calculator?operation=mul&param1=10&param2=2> 10 * 2 example </a></p>"
        		+ "<p><h4>dev - devide operands</h4> <a href = /calculator?operation=dev&param1=10&param2=2> 10 / 2 example </a></p>"; 
	}

}
