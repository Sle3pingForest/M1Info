package model;

import java.util.ArrayList;

public final class Journal {
    private static volatile Journal instance = null;

	private ArrayList<String> historiqueEnchere;

    private Journal() {
        super();
        this.historiqueEnchere = new ArrayList<String>();
    }
    
    public final static Journal getInstance() {
        if (Journal.instance == null) {
           synchronized(Journal.class) {
             if (Journal.instance == null) {
            	 Journal.instance = new Journal();
             }
           }
        }
        return Journal.instance;
    }

	public ArrayList<String> getHistoriqueEnchere() {
		return historiqueEnchere;
	}

	public void setHistoriqueEnchere(ArrayList<String> historiqueEnchere) {
		this.historiqueEnchere = historiqueEnchere;
	}

	public void ajouterAujournal(String s){
		this.historiqueEnchere.add(s);
	}
    
}
