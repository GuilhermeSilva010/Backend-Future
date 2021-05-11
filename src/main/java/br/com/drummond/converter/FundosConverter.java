package br.com.drummond.converter;

import org.springframework.stereotype.Component;

import br.com.drummond.model.Fundos;
import br.com.drummond.request.FundosAddRequest;
import br.com.drummond.response.FundosResponse;

@Component
public class FundosConverter {

	public Fundos FundosRequestToSave(FundosAddRequest fundosRequest) {

		try {
			Fundos fundo = new Fundos();
			fundo.setValor(fundosRequest.getValor());
			return fundo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public FundosResponse FundosSavedToItem(Fundos fundos) {

		try {
			FundosResponse fundosResponse = new FundosResponse();
			fundos.setName(fundosResponse.getName());
			return fundosResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
