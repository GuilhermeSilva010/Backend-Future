package br.com.drummond.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.drummond.model.CalculoFundo;
import br.com.drummond.model.Fundos;
import br.com.drummond.request.CalculoFundoAddRequest;
import br.com.drummond.response.CalculoFundoReponse;
import br.com.drummond.response.FundosResponse;

@Component
public class CalculoFundoConverter {

	public CalculoFundoReponse calculoFundoReponse(CalculoFundo calculo) {
		try {
			CalculoFundoReponse response = new CalculoFundoReponse();
			response.setCalculo(calculo.getCalculo());
			response.setName(calculo.getName());
			return response;
		} catch (Exception ex) {
			return null;
		}
	}

	public CalculoFundo calculoSave(CalculoFundoAddRequest calculoAddRequest) {

		try {
			CalculoFundo calculoFundo = new CalculoFundo();
			calculoFundo.setCalculo(calculoAddRequest.getValor());
			calculoFundo.setName(calculoAddRequest.getName());

			return calculoFundo;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public List<CalculoFundoReponse> CalculoSavedToListItem(List<CalculoFundo> calculo) {

		List<CalculoFundoReponse> list = new ArrayList<CalculoFundoReponse>();
		try {
			for (CalculoFundo calc : calculo) {
				CalculoFundoReponse calculoResponse = new CalculoFundoReponse();
				calculoResponse.setId(calc.getId());
				calculoResponse.setName(calc.getName());
				calculoResponse.setCalculo(calc.getCalculo());
				list.add(calculoResponse);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
