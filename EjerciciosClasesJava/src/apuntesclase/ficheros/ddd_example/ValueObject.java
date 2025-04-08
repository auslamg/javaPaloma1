package apuntesclase.ficheros.ddd_example;

import java.util.ArrayList;
import java.util.List;

public abstract class ValueObject {

	protected final String ID;
	List<String> values = new ArrayList<>();

    public ValueObject(String ID) {
		this.ID = ID;
    }

	protected String getID(){
		return this.ID + "#";
	};

	protected String getValues() {
		return ID;
	}

}
