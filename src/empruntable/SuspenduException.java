package empruntable;

@SuppressWarnings("serial")
public class SuspenduException extends RuntimeException {

	public SuspenduException(String s) {
		super(s);
	}
	
	public SuspenduException() {
		super();
	}
	
}
