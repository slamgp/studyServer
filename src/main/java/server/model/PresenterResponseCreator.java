package server.model;

public class PresenterResponseCreator extends ResponseCreator {

	@Override
	public String processingParametrs(String[] str) {
		ResourcesReader resourcesReader = new ResourcesReader();
		return resourcesReader.getContent(str[0]);
	}

	@Override
	protected String getMainBody() {
		String result = "<html><head><title>KOZAK:CALCULATOR</title></head>"
        		+ "<body>"
        		+ "<h3>Available resources</h3>";
		ResourcesReader resourcesReader = new ResourcesReader();
		for(String res: resourcesReader.getAllResources()) {
			result = result +"<p> <a href = /presenter?file=" + res + "> " + res + "</a></p>";
		};
		return result;
	}
}
