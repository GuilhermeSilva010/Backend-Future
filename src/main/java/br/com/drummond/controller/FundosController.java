package br.com.drummond.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.drummond.converter.CalculoFundoConverter;
import br.com.drummond.converter.FundosConverter;
import br.com.drummond.handler.HttpHandlerFundos;
import br.com.drummond.model.Fundos;
import br.com.drummond.request.CalculoFundoAddRequest;
import br.com.drummond.request.FundosAddRequest;
import br.com.drummond.request.ListPageRequest;
import br.com.drummond.response.APIReturn;
import br.com.drummond.response.CalculoFundoReponse;
import br.com.drummond.response.FundosResponse;
import br.com.drummond.service.CalculoFundoService;
import br.com.drummond.service.FundosService;

//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("")
@Controller
class FundosController {

	@Autowired
	private FundosService fundosService;

	@Autowired
	private CalculoFundoService calculoFundoService;

	@Autowired
	private FundosConverter fundosConverter;

	@Autowired
	private CalculoFundoConverter calculoConverter;

	@Autowired
	private HttpHandlerFundos httpHandlerFundos;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/fundos/add", method = RequestMethod.POST)
	public ResponseEntity<APIReturn> add(@RequestBody FundosAddRequest fundoRequest) throws IOException {

		APIReturn apiReturn = new APIReturn();
		CalculoFundoAddRequest calculoRequest = new CalculoFundoAddRequest();

		try {

			Fundos fundos = fundosService.getById(fundoRequest.getId());

			if (fundos != null) {
				fundos.setValor(fundoRequest.getValor());
				double minimo = fundos.getApliMin();
				double total = fundoRequest.getValor() / minimo;
				fundos.setCotas(total);
				calculoRequest.setName(fundoRequest.getName());
				calculoRequest.setValor(total);
				CalculoFundoReponse response = calculoConverter
						.calculoFundoReponse(calculoFundoService.save(calculoConverter.calculoSave(calculoRequest)));

				fundosService.save(fundos);

				httpHandlerFundos.handleAddMessages(apiReturn, 200, fundos);
			} else
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

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/fundos/list", method = RequestMethod.POST)
	public ResponseEntity<APIReturn> getList(@RequestBody ListPageRequest listPageRequest) {

		APIReturn apiReturn = new APIReturn();
		try {

			List<Fundos> fundos = fundosService.getListPages(listPageRequest.getData(), listPageRequest.getPage(),
					listPageRequest.getRows());
			if (!fundos.isEmpty()) {
				List<FundosResponse> fundoResponse = fundosConverter.FundosSavedToListItem(fundos);
				if (!fundoResponse.isEmpty())
					httpHandlerFundos.handleListMessages(apiReturn, 200, fundoResponse);
				else
					httpHandlerFundos.handleListMessages(apiReturn, 404, null);
			} else
				httpHandlerFundos.handleListMessages(apiReturn, 404, null);

			System.out.println(" :: Encerrando o método /api/fundos/list - 200 - OK :: ");
			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			httpHandlerFundos.handleRowsMessages(apiReturn, 400, null);

			System.out.println(" :: Encerrando o método /api/fundos/list - 400 - BAD REQUEST :: ");

			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/fundos/list/count", method = RequestMethod.POST)
	public ResponseEntity<APIReturn> count(@RequestBody ListPageRequest listPageRequest) throws IOException {
		APIReturn apiReturn = new APIReturn();
		try {

			apiReturn.setCode(200);
			apiReturn.setData(fundosService.getCount(listPageRequest.getData()));
			apiReturn.setMsg("OK");

			System.out.println(" :: Encerrando o método /api/fundos/list/count - 200 - OK :: ");
			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(" :: Encerrando o método /api/fundos/list/count - 400 - BAD REQUEST :: ");
			httpHandlerFundos.handleRowsMessages(apiReturn, 400, null);
			return new ResponseEntity<APIReturn>(apiReturn, HttpStatus.BAD_REQUEST);
		}
	}

}
