package br.com.drummond.converter;


import java.util.ArrayList;
import java.util.List;

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
			fundo.setId(fundosRequest.getId());
			return fundo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public FundosResponse FundosSavedToItem(Fundos fundos) {

		try {
			FundosResponse fundosResponse = new FundosResponse();
			fundos.setId(fundosResponse.getId());
			fundos.setName(fundosResponse.getName());
			fundos.setValor(fundosResponse.getValor());
			fundos.setApliMin(fundosResponse.getApliMin());
			fundos.setPriceUni(fundosResponse.getPriceUni());
			fundos.setRentabi(fundosResponse.getRentabi());
			fundos.setTaxa(fundosResponse.getTaxa());
			return fundosResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<FundosResponse> FundosSavedToListItem(List<Fundos> fundos) {

		List<FundosResponse> list = new ArrayList<FundosResponse>();
		try {
			for (Fundos fundo : fundos) {
				FundosResponse fundosResponse = new FundosResponse();
				fundosResponse.setId(fundo.getId());
				fundosResponse.setName(fundo.getName());
				fundosResponse.setValor(fundo.getValor());
				fundosResponse.setApliMin(fundo.getApliMin());
				fundosResponse.setPriceUni(fundo.getPriceUni());
				fundosResponse.setRentabi(fundo.getRentabi());
				fundosResponse.setTaxa(fundo.getTaxa());
				list.add(fundosResponse);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
