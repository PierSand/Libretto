package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	Model model;

    public void setModel(Model model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtinfo;

    @FXML
    void doCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	if(codice.length()<5){
    		return;
    	}
    	Esame e = model.trovaEsame(codice);
    	if(e==null){
    		txtinfo.appendText("Codice non trovato\n");
    	}
    	else {
    		txtinfo.appendText("Codice trovato\n");
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}

    }

    @FXML
    void doInserisci(ActionEvent event) {
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0 ){
    		txtinfo.appendText("Inserire i dati correttamente\n");
    		return;
    	}
    	Esame e = new Esame(codice, titolo, docente);
    	boolean result = model.addEsame(e);
    	
    	if(result){
    		txtinfo.appendText("Esame aggiunto correttamente\n");
    	}
    	else{
    		txtinfo.appendText("Esame non aggiunto correttamente(Codice duplicato)\n");
    	}
    	

    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtinfo != null : "fx:id=\"txtinfo\" was not injected: check your FXML file 'Libretto.fxml'.";

    }
}
