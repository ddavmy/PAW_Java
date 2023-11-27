package com.jsfcourse.calc;

import java.io.Serializable;
import java.util.ResourceBundle;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalcBB implements Serializable {
	private String iloscRat;
	private String kwota;
	private String procent;
	private Double result;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalcErr}")
	private ResourceBundle txtCalcErr;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalc}")
	private ResourceBundle txtCalc;
	
	@Inject
	FacesContext ctx;

	// Resource loaded "manually"
	// (here after initialization in @PostConstruct method)
	// (locale explicitly given - here based on the view )
//	@PostConstruct
//	public void postConstruct() {
//		// loading resource (notice the full "file" name)
//		txtCalc = ResourceBundle.getBundle("resources.textCalc", ctx.getViewRoot().getLocale());
//		txtCalcErr = ResourceBundle.getBundle("resources.textCalcErr", ctx.getViewRoot().getLocale());
//	}
	
	public String getIloscRat() {
		return iloscRat;
	}

	public void setIloscRat(String iloscRat) {
		this.iloscRat = iloscRat;
	}

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}
	
	public String getProcent() {
		return procent;
	}

	public void setProcent(String procent) {
		this.procent = procent;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}	

	public String calc() {
		try {
			double iloscRat = Double.parseDouble(this.iloscRat);
			double kwota = Double.parseDouble(this.kwota);
			double procent = (Double.parseDouble(this.procent)) / 100;

			result = (kwota * Math.pow(1 + procent, iloscRat) * procent / (Math.pow(1 + procent, iloscRat) - 1)) * 100;
			result = (double) Math.round(result);
			result = result / 100;

			String str = Double.toString(result);
			
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("calcComputationOkInfo"), null));
			ctx.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalc.getString("result") + ": " + str, null));
//			return true;
			return null;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
//			return false;
			return null;
		}
	}

	// Go to "showresult" if ok
//	public String calc() {
//		if (doTheMath()) {
//			return "showresult";
//		}
//		return null;
//	}
}
