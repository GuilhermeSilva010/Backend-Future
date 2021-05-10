package br.com.drummond.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.drummond.converter.FundosConverter;
import br.com.drummond.handler.HttpHandlerFundos;
import br.com.drummond.request.FundosAddRequest;
import br.com.drummond.response.APIReturn;
import br.com.drummond.response.FundosResponse;
import br.com.drummond.service.FundosService;

@Controller
class FundosController {

	@Autowired
	private FundosService fundosService;

	@Autowired
	private FundosConverter fundosConverter;

	@Autowired
	private HttpHandlerFundos httpHandlerFundos;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/fundos/add", method = RequestMethod.POST)
	public ResponseEntity<APIReturn> add(@RequestBody FundosAddRequest fundoRequest) throws IOException {

		APIReturn apiReturn = new APIReturn();

		try {
			FundosResponse fundosResponse = fundosConverter
					.FundosSavedToItem(fundosService.save(fundosConverter.FundosRequestToSave(fundoRequest)));

			if (fundosResponse != null)
				httpHandlerFundos.handleAddMessages(apiReturn, 200, fundosResponse);
			else
				httpHandlerFundos.handleAddMessages(apiReturn, 404, null);

			System.out.println(" :: Encerrando o método /api/fundos/add - 200 - OK :: ");

			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.OK);
		} catch (

		Exception ex) {
			ex.printStackTrace();

			System.out.println(" :: Encerrando o método /api/fundos/add - 200 - OK :: ");

			httpHandlerFundos.handleAddMessages(apiReturn, 400, null);

			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.BAD_REQUEST);
		}
	}
}